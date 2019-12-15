package com.qa.Hubspot.testcases;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import com.qa.Hubspot.base.BasePage;
import com.qa.Hubspot.pages.ContactsPage;
import com.qa.Hubspot.pages.HomePage;
import com.qa.Hubspot.pages.LoginPage;
import com.qa.Hubspot.util.Constants;
import com.qa.Hubspot.util.ExelUtil;

public class ContactsPageTest {
	
	WebDriver driver;
	BasePage basepage;
	Properties prop;
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	
	@BeforeMethod
		
		public void setUp() {
			
			basepage= new BasePage();
			
		    prop=basepage.inti_Properties();
		    //we have given the parameter as properties prop
		    
			driver=basepage.inti_driver(prop);
			loginpage=new LoginPage(driver);
			
			//login page dologin method returns homepage
			homepage =loginpage.doLogin(prop.getProperty("username"), prop.getProperty("pwd"));
			contactspage=homepage.goToContactsPage();
		}
	
		@Test
		public void verifyContactsPageTitleTest() {
			String title=contactspage.getContactsPageTitle();
			System.out.println("contacts page title:"+title);
			Assert.assertEquals(title, Constants.CONTACTS_PAGE_TITLE);
		}
		
		
		@DataProvider
		public Object[][] getContactsTestData(){
			Object data [][]	=ExelUtil.getTestData(Constants.CONTACT_SHEET_NAME);
			return data;
		}
		
		@Test(dataProvider="getContactsTestData")
		public void createNewContactTest(String email,String firstname,String lastname,String jobtitle) {
			//contactspage.createNewContact("lis@gmail.com","li","ya","QA");	
			
		contactspage.createNewContact(email,firstname,lastname,jobtitle);
		
		}
		
		
		
		
		
	@AfterMethod
	public void quitBrowser() {
		driver.quit();
	}
	
	
	
	
	

}
