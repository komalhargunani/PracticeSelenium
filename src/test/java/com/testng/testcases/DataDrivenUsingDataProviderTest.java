package com.testng.testcases;

import java.awt.AWTException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fb.testcases.CommonUtility;
import com.hrms.synerzip.Constants;

public class DataDrivenUsingDataProviderTest {
	
	public WebDriver driver;
	Properties prop;
	
	@BeforeMethod()
	public void setup(){
		
     driver=CommonUtility.setupFirefoxBrowser();
		
	}
	

	@Test(dataProvider="gmaillogin")
	
	public void gmailLogin(String username, String password) throws AWTException, InterruptedException, Exception{
		
		prop=CommonUtility.readPropertyFile();	
		driver.get(prop.getProperty("UploadFileURL"));
		Reporter.log("gmail login started");
		driver.findElement(By.cssSelector(prop.getProperty("CSSUsername"))).clear();
		driver.findElement(By.cssSelector(prop.getProperty("CSSUsername"))).sendKeys(username);
		driver.findElement(By.xpath(prop.getProperty("XpathUsernameNext"))).click();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector(prop.getProperty("CSSPassword"))).clear();
        driver.findElement(By.cssSelector((prop.getProperty("CSSPassword")))).sendKeys(password);	
        driver.findElement(By.xpath(prop.getProperty("XpathPasswordNext"))).click();
	}
	
	@DataProvider(name="gmaillogin")
	public Object[][] TestDataFeed(){
		ExcelUtil.excelDataConfig("E:\\synerzip_workspace\\synerzip\\hrms\\datadriven.xlsx");
		int rows = ExcelUtil.getRows(0);
		Object[][] exceldata = new Object[rows][2];
		for(int i=0;i<rows;i++){
			exceldata[i][0]= ExcelUtil.getData(0, i, 0);
			exceldata[i][1]= ExcelUtil.getData(0, i, 1);
		}
		return exceldata;
		
	}

	@AfterMethod
	
	public void closeBrowser(){
	
	
		CommonUtility.tearDown();
	}


}
