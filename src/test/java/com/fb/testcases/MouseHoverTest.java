package com.fb.testcases;

import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
		  
	
		
	}
	
@AfterMethod
	
	public void closeBrowser(){
	
	
		CommonUtility.tearDown();
	}


}
