package com.fb.testcases;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropdownTest {
	
	WebDriver driver;
	Properties prop;
	//CommonUtility c = new CommonUtility();
	
	@BeforeMethod()
	public void setup(){
		
      driver=CommonUtility.setupFirefoxBrowser();
		
	}
	
	@Test
	public void selectCountryFromDropdown() throws Exception{
		
		//without using select
		
		prop=CommonUtility.readPropertyFile();	
		driver.get(prop.getProperty("DropDownURL"));
		driver.findElement(By.cssSelector(prop.getProperty("CSSSignIn"))).click();
		driver.findElement(By.xpath(prop.getProperty("XpathMoreOptions"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("XpathCreateAccount"))).click();
		Thread.sleep(1000);
		
		/*Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		robot.keyRelease(KeyEvent.VK_PAGE_DOWN);*/
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scroll(0,400)");
		
		driver.findElement(By.xpath(prop.getProperty("XpathCountry"))).click();
		

		
		List<WebElement> element = driver.findElements(By.xpath(prop.getProperty("XpathCountryDD")));
		
		   for (int i=0; i<element.size(); i++){
	            if (element.get(i).getText().trim().equals("Albania (Shqipëri)"))
	                element.get(i).click();
	        }

	
	
		
		
	}
	
	@AfterMethod
	public void closeApplication(){
		CommonUtility.tearDown();
	}

}
