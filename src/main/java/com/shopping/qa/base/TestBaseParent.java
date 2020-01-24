package com.shopping.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.shopping.qa.util.TestUtilClass;


public class TestBaseParent {
	
	public static WebDriver driver;
	public static Properties prop;
	
	
	public TestBaseParent(){
		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\apoorva shukla\\eclipse-workspace\\FramworkDemoTest\\src\\main\\java\\com\\shopping\\qa\\config\\config.properties");
			prop.load(ip);
		}catch(FileNotFoundException f) {
			f.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace(); 
			//to print the exact problem
		}
		
	}
	
	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if(browserName.equals("Chrome")){
			System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			
		}
		else if(browserName.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Drivers\\geckodriver");
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtilClass.PAGE_lOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtilClass.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
	}

}
