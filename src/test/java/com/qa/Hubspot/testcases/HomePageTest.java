package com.qa.Hubspot.testcases;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.Hubspot.base.BasePage;
import com.qa.Hubspot.pages.HomePage;
import com.qa.Hubspot.pages.LoginPage;
import com.qa.Hubspot.util.Constants;

public class HomePageTest {
	
	WebDriver driver;
	BasePage basepage;
	Properties prop;
	LoginPage loginpage;
	HomePage homepage;
	SoftAssert softAssert;
	
		@BeforeMethod
		
		public void setUp() {
			
			basepage= new BasePage();
			
		    prop=basepage.inti_Properties();
		    //we have given the parameter as properties prop
		    
			driver=basepage.inti_driver(prop);
			loginpage=new LoginPage(driver);
			
			//login page dologin method returns homepage
			homepage =loginpage.doLogin(prop.getProperty("username"), prop.getProperty("pwd"));
			softAssert =new SoftAssert();
		}
		
//		
//	@Test	
//	public void isHeaaderExistTest() {
//		Assert.assertTrue(homepage.verifyHomePageHeader());	
//	}
	
	@Test(priority=1)
	public void HeaderTextExixtsTest() {
		softAssert.assertTrue(homepage.verifyHomePageHeader());
		Assert.assertTrue(homepage.verifyHomePageHeader());
		String text=homepage.getHomePageHeaderText();
		System.out.println(text);
		Assert.assertEquals(text,Constants.HOME_PAGE_HEADER);
		softAssert.assertAll();
	}
	
	@Test(priority=2)
	public void verifyLoggedInUserTest() {
		softAssert.assertTrue(homepage.verifyAccountName());
		Assert.assertTrue(homepage.verifyAccountName());	
		String accountname=homepage.getAccountName();
		System.out.println(accountname);
		Assert.assertEquals(accountname,prop.getProperty("account"));		
	
	}
		
	@Test(priority=3)
	public void verifyHomePageLogo() {
		Assert.assertTrue(homepage.verifyApplicationLogo());
	}
	@Test(priority=4)
	public void verifyHomePageTitle() {
		
		String title=homepage.getHomePageTitle();	
		System.out.println(title);	
		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE);
	}
		


	@AfterMethod 
	public void quitBrowser() {
	driver.quit();
		}
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
