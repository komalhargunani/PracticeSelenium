package com.fb.testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrms.synerzip.Constants;

public class uploadFileUsingRobotClass {
	
	public WebDriver driver;
	Properties prop;
	
	
	@BeforeMethod()
	public void setup(){
		
     driver=CommonUtility.setupFirefoxBrowser();
		
	}
	

	@Test
	public void Fileupload() throws AWTException, InterruptedException{
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
	    
	    // Specify the file location with extension
		 StringSelection sel = new StringSelection("E:\\robotclass_file\\testdoc");
		 
		   // Copy to clipboard
		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel,null);
		 System.out.println("selection" +sel);
		 
	    // Create object of Robot class
	  
	    

	    Robot rb = new Robot();
	    Thread.sleep(5000);
	    rb.keyPress(KeyEvent.VK_CONTROL);
	    rb.keyPress(KeyEvent.VK_V);
	    rb.keyRelease(KeyEvent.VK_CONTROL);
	    rb.keyRelease(KeyEvent.VK_V);
	    Thread.sleep(8000);
	    rb.keyPress(KeyEvent.VK_ENTER);
	    rb.keyRelease(KeyEvent.VK_ENTER);
	    Thread.sleep(10000);
	 
	}
	
	@AfterMethod
	
	public void closeBrowser(){
	
	
		CommonUtility.tearDown();
	}

}
