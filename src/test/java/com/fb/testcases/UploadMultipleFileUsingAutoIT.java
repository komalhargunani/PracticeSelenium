package com.fb.testcases;

import java.awt.AWTException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrms.synerzip.Constants;

public class UploadMultipleFileUsingAutoIT {
	

	public WebDriver driver;
	Properties prop;
	
	@BeforeMethod()
	public void setup(){
		
     driver=CommonUtility.setupFirefoxBrowser();
		
	}
	

	@Test
	public void  multipleFileupload() throws AWTException, InterruptedException, Exception{
		
		prop=CommonUtility.readPropertyFile();	
		driver.get(prop.getProperty("UploadFileURL"));
		
	    
		Reporter.log("gmail login started");
		driver.findElement(By.cssSelector(prop.getProperty("CSSUsername"))).sendKeys(Constants.usernameuploadfile);
		driver.findElement(By.xpath(prop.getProperty("XpathUsernameNext"))).click();
		Thread.sleep(5000);
        driver.findElement(By.cssSelector((prop.getProperty("CSSPassword")))).sendKeys(Constants.passworduploadfile);	
        driver.findElement(By.xpath(prop.getProperty("XpathPasswordNext"))).click();
        driver.findElement(By.xpath(prop.getProperty("XpathCompose"))).click();
	    driver.findElement(By.xpath(prop.getProperty("XpathAttach"))).click();
	    Thread.sleep(2000);
	    Runtime.getRuntime().exec(Constants.multipleautoitfile +" "+ Constants.uploadfile1);
	    Thread.sleep(5000);
	    driver.findElement(By.xpath(prop.getProperty("XpathAttach"))).click();
	    
	    Runtime.getRuntime().exec(Constants.multipleautoitfile +" "+ Constants.uploadfile12);
	}
	
	@AfterMethod
	
	public void closeBrowser(){
	
	
		CommonUtility.tearDown();
	}

}
