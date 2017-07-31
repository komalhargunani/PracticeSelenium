package com.testng.testcases;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fb.testcases.CommonUtility;

public class SampleTestng {
	
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
		System.out.println("Title of current webpage: "+ActualTitle);
	
		
	}
  
	
	@AfterMethod
	public void closeApplication(){
		CommonUtility.tearDown();
	}

}
