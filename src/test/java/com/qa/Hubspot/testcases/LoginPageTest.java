package com.qa.Hubspot.testcases;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.Hubspot.base.BasePage;
import com.qa.Hubspot.pages.HomePage;
import com.qa.Hubspot.pages.LoginPage;
import com.qa.Hubspot.util.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
@Epic("EPIC-101:Design login page feature....")
@Feature("US 1005:create a login page with title,header,signup and login method..")
public class LoginPageTest {
	
WebDriver driver;
BasePage basepage;
Properties prop;
LoginPage loginpage;
HomePage homepage;

	@BeforeMethod
	
	public void setUp() {
		
		basepage= new BasePage();
		prop=basepage.inti_Properties();
	    //we have given the parameter as properties prop
	    
		driver=basepage.inti_driver(prop);
		loginpage=new LoginPage(driver);
	
	}
	
	@Description("verify login page title test...")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority=1)
	public void verifyLoginPageTitleTest() {
	//we have to call the methods from login page by creating the object
		
	Reporter.log("Test started --> "+"verifyLoginPageTitleTest"+"\n");
	String title=loginpage.getloginPageTitle();	
	System.out.println(title);	
	Reporter.log("Login page Title is"+title);
	Assert.assertEquals(title,Constants.LOGIN_PAGE_TITLE );
	Reporter.log("Test ended-->"+"VerifyLoginPageTitleTest");
		
	}
	
	
	@Description("verify login page SighUpLink test...")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority=2)
	public void verifySighUpLink() {
		Assert.assertTrue(loginpage.signUpLinkExists());		
}


	
	@Description("verify login page feature Test...")
	@Severity(SeverityLevel.BLOCKER)
    @Test(priority=3)
    public void verifyLoginPage() {
	//   loginpage.doLogin(prop.getProperty("username"), prop.getProperty("pwd"));
     homepage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("pwd"));
	Assert.assertTrue(homepage.verifyAccountName());
	Assert.assertEquals(homepage.getAccountName(),prop.getProperty("account"));
   }
	
	
	@AfterMethod 
	public void quitBrowser() {
		driver.quit();
	}
	
	
	

}
