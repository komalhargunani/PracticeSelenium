package com.fb.testcases;

import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RightClickTest {

	public WebDriver driver;
	Properties prop;
	
	@BeforeMethod()
	public void setup(){
		
	
		
     driver=CommonUtility.setupFirefoxBrowser();
    
		
	}
	

	@Test
	public void performMouseClick() throws Exception{
		
		prop=CommonUtility.readPropertyFile();	
		driver.get(prop.getProperty("RightclickURL"));
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 	
         		

      
		
		Actions oAction = new Actions(driver);
		WebElement element=driver.findElement(By.xpath(prop.getProperty("XpathCricket")));
		
	
		
		
		oAction.doubleClick(element).build().perform(); /* this will perform double click */
		oAction.moveToElement(element).build();
		oAction.contextClick(element).build().perform();  /* this will perform right click */
		
	
		
		
		
		
		
	}
	
@AfterMethod
	
	public void closeBrowser(){
	
	
		CommonUtility.tearDown();
	}

}
