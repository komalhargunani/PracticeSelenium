package com.fb.testcases;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.FirefoxDriverManager;

public class DynamicXpathFirefor {
	
	public static WebDriver driver;
	 public static void waitForNewWindowAndSwitchToIt(WebDriver driver) throws InterruptedException {
	        String cHandle = driver.getWindowHandle();
	        String newWindowHandle = null;
	        Set<String> allWindowHandles = driver.getWindowHandles();
	        
	        //Wait for 20 seconds for the new window and throw exception if not found
	        for (int i = 0; i < 20; i++) {
	            if (allWindowHandles.size() > 1) {
	                for (String allHandlers : allWindowHandles) {
	                    if (!allHandlers.equals(cHandle))
	                    	newWindowHandle = allHandlers;
	                }
	                driver.switchTo().window(newWindowHandle);
	                break;
	            } else {
	                Thread.sleep(1000);
	            }
	        }
	        if (cHandle == newWindowHandle) {
	            throw new RuntimeException(
	                    "Time out - No window found");
	        }
	    }
	 public static String getCurrentWindowTitle() {
			String windowTitle = driver.getTitle();
			return windowTitle;
		}
	
	@BeforeMethod
	
	public void setup(){
	
     	FirefoxDriverManager.getInstance().setup();
	    DesiredCapabilities capabilities=DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		driver = new FirefoxDriver(capabilities);
		driver.get("https://www.flipkart.com/");
		
	}

	@Test
	
	public void flipkartLogin() throws Exception{
	    //using text method
		driver.findElement(By.xpath(".//a[@class='_2k0gmP'][text()='Signup']")).click();
		Reporter.log("Signup is clicked");
		String MainWindow=driver.getWindowHandle();
		
		//Wait for the element to be present
     
      waitForNewWindowAndSwitchToIt(driver);
      
      String newTitle = getCurrentWindowTitle();
      System.out.println("title of new window"+newTitle);
      
      driver.findElement(By.xpath(".//input[@class='_2zrpKA']")).sendKeys("7058164652");
      driver.findElement(By.xpath(".//button[@class='_2AkmmA _1LctnI _7UHT_c']")).click();
      
      driver.switchTo().window("MainWindow");
      
      //xpath identified on chrome xpath helper
      
      //click on ac's
      
      driver.findElement(By.xpath(".//a[@href='/air-conditioners-store?otracker=hp_nmenu_quicklinks_ACs']")).click();
      
      
      
      
		
		
	}
	
	
	
	@AfterMethod
	
	public void tearDown()
	{
		//driver.close();
	}
}
