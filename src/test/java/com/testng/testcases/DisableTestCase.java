package com.testng.testcases;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fb.testcases.CommonUtility;

public class DisableTestCase {
	WebDriver driver;
	Properties prop;
	@BeforeMethod()
	public void setup(){
		
      driver=CommonUtility.setupFirefoxBrowser();
      prop=CommonUtility.readPropertyFile();	
	  driver.get(prop.getProperty("VerifyTitleURL"));
		
	}
	
	@Test(enabled=false)
	public void verifyTitle()
	
	{
		
		
		String ActualTitle=driver.getTitle();
		System.out.println("Title of current webpage: "+ActualTitle);
	
		
	}
	
	@Test
	public void currentURL(){
		System.out.println("Current URL :" +driver.getCurrentUrl());
	}
  
	
	@AfterMethod
	public void closeApplication(){
		CommonUtility.tearDown();
	}


}
