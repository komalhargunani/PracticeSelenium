package com.testng.testcases;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;
import com.fb.testcases.CommonUtility;

public class GroupTest {
	WebDriver driver;
	Properties prop;
	@BeforeGroups(groups={"smoke","regression"})
	public void setup(){
		
      driver=CommonUtility.setupFirefoxBrowser();
      prop=CommonUtility.readPropertyFile();	
	  driver.get(prop.getProperty("VerifyTitleURL"));
		
	}
	
	/*@Test(groups={"Smoke"})
	public void verifyTitle()
	
	{
		System.out.println("Somke test");
		String ActualTitle=driver.getTitle();
		System.out.println("Title of current webpage: "+ActualTitle);
	}*/
	
	@Test(groups={"Regression"})
	public void currentURL(){
		System.out.println("regression test");
		System.out.println("Current URL :" +driver.getCurrentUrl());
	}
	
	@Test(groups={"smoke","regression"})
	public void sampleGroupTest(){
		System.out.println("smoke and regression test");
	}
  
	
	@AfterGroups(groups={"smoke","regression"})
	public void closeApplication(){
		CommonUtility.tearDown();
	}



}
