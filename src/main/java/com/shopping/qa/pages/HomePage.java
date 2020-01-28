package com.shopping.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.shopping.qa.base.TestBaseParent;

public class HomePage extends TestBaseParent {
	
	//Page Factory or Object Repository of HomePAge
	
	@FindBy(linkText="Sign in")
	WebElement signinbtn;
	
	@FindBy(xpath="//img[@class='logo img-responsive']")
	WebElement logo;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
		//this means objects of this page
	}
	
	//Actions
	public String validateHomePageTitle() {
	 return driver.getTitle();
	
	}
	
	public boolean validateLogo() {
		return logo.isDisplayed();
	}
	
	//jhdscbjskd
	public LoginPage loginBtn() {
		signinbtn.click();
		return new LoginPage();
	
	}
	
	
	
}
