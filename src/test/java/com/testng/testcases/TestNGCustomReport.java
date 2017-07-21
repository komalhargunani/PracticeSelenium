package com.testng.testcases;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fb.testcases.CommonUtility;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class TestNGCustomReport {
	
	WebDriver driver;
	Properties prop;
	
	@Test
	public void setup(){	
      driver=CommonUtility.setupFirefoxBrowser();
      prop=CommonUtility.readPropertyFile();	
	  driver.get(prop.getProperty("VerifyTitleURL"));	
	}
	 
    @Test

    public void verifySeleniumBlog(){



          // Create object of extent report and specify the Class name in get method

          // in my case I have used AdvanceReporting.class

          ExtentReports extent = ExtentReports.get(TestNGCustomReport.class);



          // Call init method and specify the location where you want to save this report

          // second parameter is set to true it means it will overwrite report with new one

          extent.init("E:\\synerzip_workspace\\synerzip\\hrms\\testngcustomreport.html", true);



          // Start Test

          extent.startTest("Verify Page Title");
          extent.log(LogStatus.INFO, "Navigated to flipkart");

          // get title

          String ActualTitle=driver.getTitle();
  		System.out.println("Title of current webpage: "+ActualTitle);


          // Verify title

           Assert.assertTrue(ActualTitle.contains("Online"));

           extent.log(LogStatus.PASS, "Title verified");



           // In case you want to attach screenshot then use below method

           // I am taking random image but you have to take screenshot at run time and specify the path

           extent.attachScreenshot("E:\\synerzip_workspace\\synerzip\\hrms\\Homepage.jpg");

         
           //close browser

           extent.log(LogStatus.INFO, "Browser closed");
           driver.quit();



           // close report

           extent.endTest();



    }


}
