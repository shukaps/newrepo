package com.shopping.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.shopping.qa.base.TestBaseParent;

public class LoginPage extends TestBaseParent {
	
	@FindBy(id="email")
	WebElement emailid;
	
	@FindBy(id="passwd")
	WebElement passwrd;
	
	@FindBy(name="SubmitLogin")
	WebElement signinbtn;
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	public AccountPage login(String email, String pd)
	{
		emailid.sendKeys(email);
		passwrd.sendKeys(pd);	
		signinbtn.click();
		return new AccountPage();
		
		
		
	}
	
}
