package com.qa.Hubspot.base;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	
/**
 * This method returns a driver when we provide a browser
 * 
 * 
 */
	

     WebDriver driver;
     Properties prop;
     
     public static ThreadLocal<WebDriver> tldriver=new ThreadLocal<WebDriver>();
     public static synchronized WebDriver getDriver() {
    	 return tldriver.get();
     }
     
     
	//instead of taking the browser value from base page .i take it from config properties which is loaded by Properties prop
	public WebDriver inti_driver(Properties prop) {
		
		String browser=prop.getProperty("browser");
		
		
		if(browser.equals("chrome")) {
		
		WebDriverManager.chromedriver().setup();
		//driver=new ChromeDriver();
		tldriver.set(new ChromeDriver());
		}else if(browser.equals("firefox")) {
			
			WebDriverManager.chromedriver().setup();	
			//driver=new FirefoxDriver();
			tldriver.set(new FirefoxDriver());
		}else if(browser.equals("safari")) {
			
			WebDriverManager.getInstance(SafariDriver.class).setup();
			//driver=new SafariDriver();
			tldriver.set(new SafariDriver());//created for listeners
		}else {
			
			System.out.println("Please pass the correct browser name...");
			
		}
		
		
	getDriver().manage().window().fullscreen();	//c
	getDriver().manage().deleteAllCookies();//c
	//get the url also from config file which is loaded by properties prop
	getDriver().get(prop.getProperty("url"));//c
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return getDriver();
	
		
	}
	
	//This method is used to intiate the properties from config.properties file
	
	
	public Properties inti_Properties() {
		prop=new Properties();
		//create a link or interaction between base page and config.properties file
		
		try {
			FileInputStream ip=new FileInputStream("C:\\Users\\user\\eclipse-workspace\\yes-m system\\OctBatchPOMSeries\\src\\main\\java\\com\\qa\\Hubspot\\config\\config.properties");
			
			prop.load(ip);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return prop;
	}
	
	public String getScreenshot() {
		File src= ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		String path=System.getProperty("user.dir")+"/screenshots/"+System.currentTimeMillis()+".png";
		File destination= new File(path);
		try 
		{
			FileUtils.copyFile(src, destination);
		
		}catch(IOException e) {
		System.out.println("Capture Failed" +e.getMessage());
		}
		return path;
		

	}
	

}
