package com.fb.testcases;

import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.FirefoxDriverManager;

public class SyncIssuesTest {
	public WebDriver driver;
	Properties prop;
	
	@BeforeMethod()
	public void setup(){
		
     driver=CommonUtility.setupFirefoxBrowser();
    	
	}
	

	@Test
	public void performFluentwait() throws Exception{
		

		
		prop=CommonUtility.readPropertyFile();	
		driver.get(prop.getProperty("SyncIssueURL"));
		
		Alert confirmationAlert = driver.switchTo().alert();
		String alertText = confirmationAlert.getText();
		System.out.println("Alert text is " + alertText);
		confirmationAlert.dismiss();
		 
		CommonUtility.isElementPresnt(driver,".//*[@id='txtSource']", 20).sendKeys("Bangalore");
		 
		CommonUtility.isElementPresnt(driver,".//*[@id='txtDestination']", 20).sendKeys("Chennai");
	}
	

@AfterMethod	
	public void closeBrowser(){
		CommonUtility.tearDown();
	}


}
