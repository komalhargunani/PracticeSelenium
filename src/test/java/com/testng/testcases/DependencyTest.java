package com.testng.testcases;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.fb.testcases.CommonUtility;

public class DependencyTest {
	
	WebDriver driver;
	Properties prop;
	
	@Test
	public void setup(){	
      driver=CommonUtility.setupFirefoxBrowser();
      prop=CommonUtility.readPropertyFile();	
	  driver.get(prop.getProperty("VerifyTitleURL"));	
	}
	
	@Test(dependsOnMethods={"setup"})
	public void verifyTitle()
	{
    	String ActualTitle=driver.getTitle();
		System.out.println("Title of current webpage: "+ActualTitle);
	}
	
	@Test(dependsOnMethods={"setup"})
	public void currentURL(){
		System.out.println("Current URL :" +driver.getCurrentUrl());
	}
  
	
	@Test(dependsOnMethods={"setup","verifyTitle","currentURL"})
	public void closeApplication(){
		CommonUtility.tearDown();
	}



}
