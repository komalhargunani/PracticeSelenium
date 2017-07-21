package com.testng.testcases;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fb.testcases.CommonUtility;

public class LogTestCase {
	WebDriver driver;
	Properties prop;
	
	
	@BeforeMethod()
	public void setup(){
		
      driver=CommonUtility.setupFirefoxBrowser();
		
	}
	
	@Test
	public void verifyTitle()
	
	{
		 Logger logger=Logger.getLogger("Flipkart");
	       PropertyConfigurator.configure("E:\\synerzip_workspace\\synerzip\\hrms\\Log4j.properties");
		prop=CommonUtility.readPropertyFile();	
		driver.get(prop.getProperty("VerifyTitleURL"));
		logger.info("Browser Opened");
		String ActualTitle=driver.getTitle();
		String ExpectedTitle="Online Shopping Site for Mobiles, Fashion, Books, Electronics, Home Appliances and More";
		System.out.println(ActualTitle);
		Assert.assertEquals(ActualTitle, ExpectedTitle);
		logger.info("verified  actual title"+ActualTitle);
	
		
	}
  
	
	@AfterMethod
	public void closeApplication(){
		CommonUtility.tearDown();
	}

}
