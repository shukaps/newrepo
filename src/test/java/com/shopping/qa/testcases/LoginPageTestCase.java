package com.shopping.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.shopping.qa.base.TestBaseParent;
import com.shopping.qa.pages.AccountPage;
import com.shopping.qa.pages.HomePage;
import com.shopping.qa.pages.LoginPage;
import com.shopping.qa.util.ReadExcel;

public class LoginPageTestCase extends TestBaseParent {
	
	LoginPage loginpage;
	HomePage hompage;
	AccountPage actpage;
	
	public LoginPageTestCase() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		
		initialization();
		hompage = new HomePage();
		
		
		loginpage = new LoginPage();
		loginpage = hompage.loginBtn();
		
		
		
	}
	
	@DataProvider
	public Object[][] passData() {
		
		ReadExcel read = new ReadExcel("C:\\Users\\apoorva shukla\\eclipse-workspace\\FramworkDemoTest\\src\\main\\java\\com\\shopping\\qa\\testdata\\TestData.xlsx");
		int row = read.getrowcount(0);
		int col = read.getcolcount(0);
		
		Object[][] data = new Object[row][col];
		for(int i=1;i<=row;i++) {
			for(int j=0;j<=col;j++) {
				data[i][j]= read.getDate(0, i, j);
			}
			
		}
		return data;
		
	}
	
	@Test(dataProvider="passData")
	public void login(String EmailID, String Passwrd)
	{
		actpage=loginpage.login(EmailID, Passwrd);
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
	

}
