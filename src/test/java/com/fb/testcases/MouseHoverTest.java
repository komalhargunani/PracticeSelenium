package com.fb.testcases;

import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MouseHoverTest {

	public WebDriver driver;
	Properties prop;
	
	@BeforeMethod()
	public void setup(){
		
     driver=CommonUtility.setupFirefoxBrowser();
		
	}
	

	@Test
	public void performMouseHover() throws Exception{
		
		prop=CommonUtility.readPropertyFile();	
		driver.get(prop.getProperty("MouseHoverURL"));
		 
		

      String parentwindow = driver.getWindowHandle();
		  for (String allwindows : driver.getWindowHandles()) {
			  if(allwindows.equals(parentwindow)){
		        System.out.println("Inside Main window");
			  }else{
				  driver.switchTo().window(allwindows).close();
			  }
		  }
		driver.switchTo().window(parentwindow);
		Actions builder=new Actions(driver);
		WebElement jobs=driver.findElement(By.xpath("//div[contains(text(),'Jobs')]"));
		builder.moveToElement(jobs).build().perform();
		
		driver.findElement(By.xpath("//a[@data-ga-track='Main Navigation Jobs|Jobs by Skill']")).click();
		  
	/*	// Type something on Skill textbox
		driver.findElement(By.name("qp")).sendKeys("test");
		 
		// Create object on Actions class
		Actions builder=new Actions(driver);
		 
		// find the element which we want to Select from auto suggestion
		WebElement ele=driver.findElement(By.xpath(".//*[@id='autosuggest']/ul/li[2]/a"));
		 
		// use Mouse hover action for that element
		builder.moveToElement(ele).build().perform();
		 
		// Give wait for 2 seconds 
		Thread.sleep(2000);
		 
		// finally click on that element
		builder.click(ele).build().perform();*/
		
		
		
	}
	
@AfterMethod
	
	public void closeBrowser(){
	
	
		//CommonUtility.tearDown();
	}


}
