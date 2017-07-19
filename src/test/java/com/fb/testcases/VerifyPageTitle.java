package com.fb.testcases;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VerifyPageTitle {
	
	WebDriver driver;
	Properties prop;
	//CommonUtility c = new CommonUtility();
	
	@BeforeMethod()
	public void setup(){
		
      driver=CommonUtility.setupFirefoxBrowser();
		
	}
	
	@Test
	public void verifyTitle()
	
	{
		
		prop=CommonUtility.readPropertyFile();	
		driver.get(prop.getProperty("VerifyTitleURL"));
		String ActualTitle=driver.getTitle();
		String ExpectedTitle="Online Shopping Site for Mobiles, Fashion, Books, Electronics, Home Appliances and More";
		System.out.println(ActualTitle);
		Assert.assertEquals(ActualTitle, ExpectedTitle);
	
		
	}
  
	
	@AfterMethod
	public void closeApplication(){
		CommonUtility.tearDown();
	}
}
