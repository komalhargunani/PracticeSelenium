package com.fb.testcases;


import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RadioButtonTest {
	WebDriver driver;
	Properties prop;
	
	
	@BeforeMethod()
	public void setup(){
		
      driver=CommonUtility.setupFirefoxBrowser();
		
	}
	
	@Test
	public void verifyRadioButton(){
		
		prop=CommonUtility.readPropertyFile();					
		driver.get(prop.getProperty("RadioButtonURL"));
		driver.findElement(By.cssSelector(prop.getProperty("CSSsignup"))).click();
		//scroll a window
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("scroll(0,350)");
		//click on male radiobutton
		WebElement maleradio= driver.findElement(By.id(prop.getProperty("IDRadioMale")));
		boolean malebutton = maleradio.isSelected();
		if(malebutton==false){
			maleradio.click();
		}
		Reporter.log("male gender is selected");
		
		
	}
	@AfterMethod
	public void closeApplication(){
		CommonUtility.tearDown();
	}
}
