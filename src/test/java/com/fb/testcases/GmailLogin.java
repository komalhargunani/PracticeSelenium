package com.fb.testcases;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.FirefoxDriverManager;

public class GmailLogin {
	
	public static WebDriver driver;
	

	@BeforeMethod
	public void setup(){
		
		
		FirefoxDriverManager.getInstance().setup();
	    DesiredCapabilities capabilities=DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		driver = new FirefoxDriver(capabilities);
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
		driver.get("http://gmail.com");
		
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	
	public void gmailLogin() throws Exception{
		
		
		
		
		
		
		 
		
		Reporter.log("gmail login started");
		driver.findElement(By.cssSelector("input#identifierId")).sendKeys("komal.hargunani@synerzip.com");
		driver.findElement(By.xpath("html/body/div[1]/div[1]/div[2]/div[2]/form/div[2]/div[1]/div[2]/div[1]/div[2]")).click();
		/* WebDriverWait wait = new WebDriverWait(driver,30);
		    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[aria-label='Enter your password']")));*/
		Thread.sleep(5000);
        driver.findElement(By.cssSelector("input[aria-label='Enter your password']")).sendKeys("waheguru@1234");	
        driver.findElement(By.xpath("html/body/div[1]/div[1]/div[2]/div[2]/form[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]")).click();
        driver.findElement(By.xpath("//div[contains(text(),'COMPOSE')]")).click();
	    driver.findElement(By.xpath("//div[contains(@class, 'a1 aaA aMZ')]")).click();
	    
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
	
	public void tearDown(){
		
		driver.close();
		
	}
	
}
