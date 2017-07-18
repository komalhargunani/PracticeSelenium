package com.fb.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;

public class CommonUtility {
	 public static WebDriver driver = null;
	 public static Properties prop;
	 
	
	
    public static Properties readPropertyFile(){
    	File file = new File("E:\\synerzip_workspace\\synerzip\\hrms\\testdata.properties");

		
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		 prop = new Properties();
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
		
    }	
	public static WebDriver setupFirefoxBrowser(){
		
		FirefoxDriverManager.getInstance().setup();
	    DesiredCapabilities capabilities=DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		driver = new FirefoxDriver(capabilities);
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    Reporter.log("firefox browser is started");
	    return driver;
		
		
	}
	public static WebDriver setupChromeBrowser(){
		  ChromeDriverManager.getInstance().setup();
		  driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		  Reporter.log("chrome browser is started");
		  return driver;
		
	}
    public static WebDriver setupIEBrowser(){

		  InternetExplorerDriverManager.getInstance().setup();
		  driver = new InternetExplorerDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		  driver.manage().window().setSize(new Dimension(1024,768));
		  Reporter.log("IE browser is started");
		  return driver;
    	
    }
    public static WebDriver tearDown(){
    	
    	driver.close();
    	Reporter.log("application closed");
    	return driver;
    }
}