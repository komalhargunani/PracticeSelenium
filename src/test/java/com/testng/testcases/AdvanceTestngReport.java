package com.testng.testcases;

import static org.testng.Assert.assertTrue;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.fb.testcases.CommonUtility;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class AdvanceTestngReport {
	
	ExtentReports report;
	ExtentTest logger;
	WebDriver driver;
	Properties prop;
	
	@Test
	public void verfiyTitle(){
		report =new ExtentReports("E:\\TestNGAdvancedReport\\report\\flipkart.html");
		logger = report.startTest("Verifytitle");
		driver=CommonUtility.setupFirefoxBrowser();
		//driver.manage().window().maximize();
		prop=CommonUtility.readPropertyFile();	
		driver.get(prop.getProperty("VerifyTitleURL"));
		String title=driver.getTitle();
		assertTrue(title.contains("google"));
		logger.log(LogStatus.PASS, "title verified");
		
		
		
	}

   @AfterMethod
   public void tearDown(ITestResult result){
	   if(result.getStatus()==ITestResult.FAILURE){
		 String Screenshotpath =  CommonUtility.captureScreenShot(result.getName());
		 String image=logger.addScreencast(Screenshotpath);
		 logger.log(LogStatus.FAIL, "Tiltle verification",image);
		
	   }
   
   report.endTest(logger);
   report.flush();
  driver.get("E:\\TestNGAdvancedReport\\report\\flipkart.html");
   
   }


}
