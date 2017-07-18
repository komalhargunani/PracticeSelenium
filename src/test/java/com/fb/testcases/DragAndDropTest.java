package com.fb.testcases;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DragAndDropTest {
	
	public WebDriver driver;
	Properties prop;
	
	@BeforeMethod()
	public void setup(){
		
     driver=CommonUtility.setupFirefoxBrowser();
		
	}
	
	@Test
	public void performDragAndDrop(){
		prop=CommonUtility.readPropertyFile();	
		driver.get(prop.getProperty("DragAndDropURL"));

		WebElement source = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement destination = driver.findElement(By.xpath("//div[@id='droppable']"));
		Actions action = new Actions(driver);
		action.dragAndDrop(source, destination).build().perform();
		
	}
	
@AfterMethod
	
	public void closeBrowser(){
	
	
		//CommonUtility.tearDown();
	}


}
