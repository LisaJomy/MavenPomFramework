package com.qa.Hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.Hubspot.base.BasePage;
import com.qa.Hubspot.util.Constants;
import com.qa.Hubspot.util.ElementUtil;

public class LoginPage extends  BasePage{
	WebDriver driver;
	ElementUtil elementUtil;
	

	//page objects
	
	By emailId=By.id("username");
	By password=By.id("password");
	By signUpLink=By.linkText("Sign up");
	By loginButton=By.id("loginBtn");
	//By LogoButton=By.cssSelector("li>a#nav-primary-home");
			
//create page class constructor	
public LoginPage(WebDriver driver) {
this.driver=driver;	
elementUtil=new ElementUtil(driver);	
}
	
//Create actions/Methods
//get title of the page
public String getloginPageTitle() {
	elementUtil.waitForPageTitle(Constants.LOGIN_PAGE_TITLE);
	return elementUtil.doGetTitle();
	}



public boolean signUpLinkExists() {
	return elementUtil.doIsDisplayed(signUpLink);
}

	

public HomePage doLogin(String username,String pwd) {
	elementUtil.doSendKeys(emailId, username);
	elementUtil.doSendKeys(password, pwd);
	elementUtil.doClick(loginButton);
//	try {
//		Thread.sleep(50000);
//	} catch (InterruptedException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
	
return new HomePage(driver);	
}




	
	
	
	
	
	
	
	
	
	
	

}
