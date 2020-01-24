package com.shopping.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.shopping.qa.base.TestBaseParent;
import com.shopping.qa.pages.HomePage;
import com.shopping.qa.pages.LoginPage;

public class HomePageTestcase extends TestBaseParent {
	
	HomePage homepage;
	LoginPage loginpage;
	
	public HomePageTestcase() {
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		homepage= new HomePage();
	}
	
	@Test(priority=1)
	public void HomePageTitle() {
		String title = homepage.validateHomePageTitle();
		Assert.assertEquals(title, "My Store");
	}
	
	@Test(priority=2)
	public void HomePageLogo() {
		boolean b = homepage.validateLogo();
		Assert.assertTrue(b);
	}
	
	@Test(priority=3)
	public void Loginbtn() {
		loginpage = homepage.loginBtn();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
