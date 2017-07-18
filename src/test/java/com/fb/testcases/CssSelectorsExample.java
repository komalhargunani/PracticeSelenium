package com.fb.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.FirefoxDriverManager;

public class CssSelectorsExample {
	
	public static WebDriver driver;
	
	@BeforeMethod
	
	public void setup(){
	
     	FirefoxDriverManager.getInstance().setup();
	    DesiredCapabilities capabilities=DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		driver = new FirefoxDriver(capabilities);
		driver.get("https://www.linkedin.com/");
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
	}
	
	@Test
	
	public void linkedinSignup(){
		

	
	//using xpath
	System.out.println("------xpath---------");
	//driver.findElement(By.xpath(".//input[@id='login-submit']")).click();
	//driver.findElement(By.xpath(".//a[@class='link-forgot-password']")).click();
	
	
	//using cssselectors
	System.out.println("------CSS---------");
	//-------using id
	//driver.findElement(By.cssSelector("input#login-submit")).click();
	//----------using class
	//driver.findElement(By.cssSelector("a.link-forgot-password")).click();
	//-----------using attribute
	driver.findElement(By.cssSelector("input[name='firstName']")).sendKeys("komal");
	//-------using substring prefix
	//driver.findElement(By.cssSelector("input#reg-email[class^='reg']")).sendKeys("komal");
	//-------using substring suffix
	//driver.findElement(By.cssSelector("input#reg-email[class$='email']")).sendKeys("komal");
	//-------using substring substring
	//driver.findElement(By.cssSelector("input#reg-email[class*='ema']")).sendKeys("komal");
	//using-------inner text
	//driver.findElement(By.cssSelector("input:contains(^pass$)")).sendKeys("***");
	
	
		
	
	
	
	
	
	
     
	
	}
	
	@AfterMethod
	
	public void tearDown(){
		//driver.close();
	}

}
