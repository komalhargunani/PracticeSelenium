package com.fb.testcases;


import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckboxTest {
	WebDriver driver;
	Properties prop;
	
	
	@BeforeMethod()
	public void setup(){
		
      driver=CommonUtility.setupFirefoxBrowser();
		
	}
	
	@Test
	public void verifyCheckbox(){
		
		prop=CommonUtility.readPropertyFile();	
		driver.get(prop.getProperty("CheckBoxURL"));
		// Get the count of all available checkboxes.
		List<WebElement> list = driver.findElements(By.tagName("input"));
 
		
		for (int i = 0; i < list.size(); i++) {
			
			if (list.get(i).getAttribute("type").trim()
					.equalsIgnoreCase("checkbox")) {
 
				
				System.out.println("CheckBox = " + i + " "
						+ list.get(i).getAttribute("value").trim());
 
				
				if (!(list.get(i).isSelected())) {
					list.get(i).click();
				} else {
					
					list.get(i).click();
				}
			
			}
		}
		
	}
	@AfterMethod
	public void closeApplication(){
		CommonUtility.tearDown();
	}
}
