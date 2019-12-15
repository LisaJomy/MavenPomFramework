package com.qa.Hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.Hubspot.base.BasePage;
import com.qa.Hubspot.util.ElementUtil;


public class HomePage extends BasePage {
	WebDriver driver;
	ElementUtil elementUtil;
	
	
	By header=By.xpath("//i18n-string[text()='Take a closer look at how HubSpot works.']");
	By accountname=By.cssSelector("span.account-name ");
	By logo=By.cssSelector("li>a#nav-primary-home");
	
	//Contact page locators for page chaining
	By contactsParentTab=By.id("nav-primary-contacts-branch");
	By contactsChildTab=By.id("nav-secondary-contacts");
	
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		elementUtil=new ElementUtil(driver);
		elementUtil.waitForElementPresent(header);
	}
	
//title	
public String getHomePageTitle() {
	return elementUtil.doGetTitle();
}
//header displayed
public boolean verifyHomePageHeader(){
	elementUtil.waitForElementPresent(header);//don't use here
    return elementUtil.doIsDisplayed(header);
}

//header text verify
	
public String getHomePageHeaderText() {
	return elementUtil.doGetText(header);
}

//Verify account number
public boolean verifyAccountName() {
	elementUtil.waitForElementPresent(accountname);
	return elementUtil.doIsDisplayed(accountname);
}
	
public String getAccountName() {
	return elementUtil.doGetText(accountname);
}
	
public boolean verifyApplicationLogo()	{
	return elementUtil.doIsDisplayed(logo);
}
public ContactsPage goToContactsPage() {
	elementUtil.waitForElementPresent(contactsParentTab);
	elementUtil.doClick(contactsParentTab);
	elementUtil.waitForElementPresent(contactsChildTab);
	elementUtil.doClick(contactsChildTab);
	return new ContactsPage(driver);
}
	

}
