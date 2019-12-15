package com.qa.Hubspot.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public ElementUtil(WebDriver driver) {
		this.driver=driver;
		wait=new WebDriverWait(driver,30);
	}
	
	//****generic method for locating WebElement
	
	public WebElement getElement(By locator) {
		WebElement element=null;
	   try {
	    element =driver.findElement(locator);
	   } catch(Exception e){
		   System.out.println("some exception occured while creating the webelement:"+locator);
		System.out.println(e.getMessage());   
	   }
		return element;
		
	}
	
	//generic method for click

	public void doClick(By locator) {
	try {	
		getElement(locator).click();
	}catch(Exception e) {
		System.out.println("some exception occured while clicking the webelement:"+locator);
		System.out.println(e.getMessage());
	}
}
	//generic method to click an element using actions class(if we cannot perform .click due to popup)
	public void doActionClick(By locator) {
		try {
		Actions action=new Actions(driver);
		action.click(getElement(locator)).build().perform();
		}catch(Exception e) {
			System.out.println("some exception occured while clicking the webelement:"+locator);
			System.out.println(e.getMessage());	
			
		}
		
	}

//	generic method for sendKeys ...
	
	public void doSendKeys(By locator,String... value) {
		try {
		
		getElement(locator).clear();
		getElement(locator).sendKeys(value);
		}catch(Exception e) {
			System.out.println("some exception occured while sending the text to webelement:"+locator);
			System.out.println(e.getMessage());	
		}
		
	}
	
	//Generic method to perform senkeys using actions class
	
	public void doActionSendKeys(By locator, String... value) {
		try {
	Actions act =new Actions(driver);
	act.sendKeys(getElement(locator),value).build().perform();
		}catch(Exception e) {
			System.out.println("some exception occured while sending the text to webelement:"+locator);
			System.out.println(e.getMessage());		
		}
	}

	//***generic method for getText method
	
	public String doGetText(By locator) {
		 String	text=null;
		try {
     text  =getElement(locator).getText();	
		
			}catch(Exception e) {
				System.out.println("some exception occured while getting the text from the webelement:"+locator);
				System.out.println(e.getMessage());	
				
			}
		return text;		
	}
	
//Generic	isdisplayed with flag
	
public boolean doIsDisplayed(By locator) {
	waitForElementPresent(locator);
	boolean flag=false;
try {	
	flag =getElement(locator).isDisplayed();
	}catch(Exception e) {
		System.out.println("some exception occured while checking isdisplayed for webelement:"+locator);
		System.out.println(e.getMessage());	
	}
 	return flag;
}
	
//Generic method for title which is not a webelement

public String doGetTitle() {
	String title=null;	
	try {
	title=driver.getTitle();
	}catch(Exception e) {
		
		System.out.println("some exception occured while getting the title of the title");
		System.out.println(e.getMessage());		
	}
	return title;
}
	
//Generic method to move to element
public void doActionMoveToElement(By locator) {
try {
	Actions act1=new Actions(driver);
	act1.moveToElement(getElement(locator)).build().perform();	
   }catch(Exception e)	{
	   System.out.println("some exception got while moving to the webelement:" +locator);
	   System.out.println(e.getMessage());		
   }
	
}	
public void waitForPageUrl(String url) {
	wait.until(ExpectedConditions.urlToBe(url));
}

public void waitForPageTitle(String title) {
	wait.until(ExpectedConditions.titleContains(title));
}

public void waitForElementPresent(By locator) {
	wait.until(ExpectedConditions.presenceOfElementLocated(locator));
}









}
