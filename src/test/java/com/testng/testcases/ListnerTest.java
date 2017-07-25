package com.testng.testcases;

import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.fb.testcases.CommonUtility;



@Listeners(com.testng.testcases.TestNGListner.class)
public class ListnerTest {
	WebDriver driver;
	Properties prop;
	@BeforeMethod()
	public void setup(){
		
      driver=CommonUtility.setupFirefoxBrowser();
      prop=CommonUtility.readPropertyFile();	
	  driver.get(prop.getProperty("VerifyTitleURL"));
		
	}
	
	@Test
	public void verifyTitle()
	
	{
		
		
		String ActualTitle=driver.getTitle();
		System.out.println("Title of current webpage: "+ActualTitle);
	
		
	}
	
	@Test
	public void currentURL(){
		System.out.println("Current URL :" +driver.getCurrentUrl());
	}
  
	
	@Test
	public void failedtestcase(){
		
		System.out.println("Testing failed test case");
		Assert.assertTrue(true);
	}
	
	@AfterMethod
	public void closeApplication(){
		CommonUtility.tearDown();
	}



}
