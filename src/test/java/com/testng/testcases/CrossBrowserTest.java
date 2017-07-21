package com.testng.testcases;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.fb.testcases.CommonUtility;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;

public class CrossBrowserTest {
	Properties prop=CommonUtility.readPropertyFile();
WebDriver driver;
	
	@Test
	@Parameters("Browser")
	public  void test1(String browser) {
		
		
	if(browser.equalsIgnoreCase("FF")){
			
		FirefoxDriverManager.getInstance().setup();
	    DesiredCapabilities capabilities=DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		 driver= new FirefoxDriver(capabilities);
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    Reporter.log("firefox browser is started");
	  	
	 
	}
	else if(browser.equalsIgnoreCase("IE")){
		
		  InternetExplorerDriverManager.getInstance().setup();
		 driver = new InternetExplorerDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		  driver.manage().window().setSize(new Dimension(1024,768));
		  Reporter.log("IE browser is started"); 
		
	}
	else if(browser.equalsIgnoreCase("CHROME")){
		 ChromeDriverManager.getInstance().setup();
		  driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		  Reporter.log("chrome browser is started");
		
	}
	
    driver.get("https://flipkart.com");
	
	System.out.println("Title :" +driver.getTitle());
	driver.close();

	
	}



}
