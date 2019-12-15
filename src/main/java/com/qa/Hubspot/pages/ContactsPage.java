package com.qa.Hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.Hubspot.base.BasePage;
import com.qa.Hubspot.util.Constants;
import com.qa.Hubspot.util.ElementUtil;

public class ContactsPage extends BasePage {
	
	WebDriver driver;
	ElementUtil elementUtil;
	
	
	By createContactButton=By.xpath("//span[text()='Create contact']");
	By createContactFormButton=	By.xpath("//button/span[text()='Create contact']");	
	
	 By email=By.xpath("//input[@data-field='email']");
	By firstName=By.xpath("//input[@data-field='firstname']");
	By lastName=By.xpath("//input[@data-field='lastname']");
	By jobTitle=By.xpath("//input[@data-field='jobtitle']");
	
	public ContactsPage(WebDriver driver) {
		this.driver=driver;
		elementUtil=new ElementUtil(driver);
	}
	
public String getContactsPageTitle()	{
	elementUtil.waitForPageTitle(Constants.CONTACTS_PAGE_TITLE);
	return elementUtil.doGetTitle();
}
	
	
public void createNewContact(String mail,String fname,String  lname,String jtitle) {	
	elementUtil.waitForElementPresent(createContactButton);
	elementUtil.doActionClick(createContactButton);
	elementUtil.waitForElementPresent(email);
	elementUtil.doActionSendKeys(email, mail);
	elementUtil.waitForElementPresent(firstName);
	elementUtil.doActionSendKeys(firstName, fname);
	elementUtil.waitForElementPresent(lastName);
	elementUtil.doActionSendKeys(lastName, lname);
	elementUtil.doActionSendKeys(jobTitle);
	elementUtil.doActionSendKeys(jobTitle, jtitle);
	
	elementUtil.waitForElementPresent(createContactFormButton);
	elementUtil.doActionClick(createContactFormButton);
}
	
	
	
	

}
