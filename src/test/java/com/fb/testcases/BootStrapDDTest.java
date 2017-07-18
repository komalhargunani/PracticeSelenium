package com.fb.testcases;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BootStrapDDTest {

	WebDriver driver;
	Properties prop;
	//CommonUtility c = new CommonUtility();
	
	@BeforeMethod()
	public void setup(){
		
      driver=CommonUtility.setupFirefoxBrowser();
		
	}
	
	@Test
	
	public void verifyDD() throws Exception{
		prop=CommonUtility.readPropertyFile();	
		driver.get(prop.getProperty("BootstrapDDURL"));
		 
	      driver.findElement(By.xpath(prop.getProperty("XpathDDMenu"))).click();
	 
	       Thread.sleep(2000);
	 
	       List<WebElement> list = driver.findElements(By.xpath(prop.getProperty("XpathDDL")));
	 
	       for (WebElement ele : list)
	 
	       {
	 
	          System.out.println("Values " + ele.getAttribute("innerHTML"));
	 
	          if (ele.getAttribute("innerHTML").contains("JavaScript")) {
	 
	             ele.click();
	 
	             break;
	 
	          }
	 
	       }
	 
	   }
	
	@AfterMethod
	public void closeApplication(){
		CommonUtility.tearDown();
	}
}
