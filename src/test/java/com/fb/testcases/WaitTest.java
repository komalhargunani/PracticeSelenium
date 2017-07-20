package com.fb.testcases;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.base.Function;

public class WaitTest {
	

	public WebDriver driver;
	Properties prop;
	
	@BeforeMethod()
	public void setup(){
		
     driver=CommonUtility.setupFirefoxBrowser();
    	
	}
	

	@Test
	public void performWait() throws Exception{
		
		prop=CommonUtility.readPropertyFile();	
		driver.get(prop.getProperty("WaitURL"));
		/*implicit wait : WebDriver to poll the DOM for a certain amount 
		of time when trying to find an element or elements if they are not immediately available*/
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		/*Explicit wait: An explicit wait can only be implemented in cases where 
		synchronization is needed and the rest of the script is working fine*/
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search for Products, Brands and More']")));   
		driver.findElement(By.xpath("//input[@placeholder='Search for Products, Brands and More']")).clear();    
		driver.findElement(By.xpath("//input[@placeholder='Search for Products, Brands and More']")).sendKeys("wrangler");
		driver.findElement(By.xpath("//input[@placeholder='Search for Products, Brands and More']")).click();
		
	}
		  
		 




@AfterMethod	
	public void closeBrowser(){
		CommonUtility.tearDown();
	}




}