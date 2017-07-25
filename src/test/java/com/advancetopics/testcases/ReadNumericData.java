package com.advancetopics.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fb.testcases.CommonUtility;
import com.hrms.pages.LoginPage;
import com.hrms.synerzip.Constants;

public class ReadNumericData {
	
	WebDriver driver;
	@BeforeMethod()
	public void setup(){
		
      driver=CommonUtility.setupFirefoxBrowser();
		
	}
	
	@Test()
	public void readJxlData()
	{
		
		driver.get(Constants.URL);
		
	    driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	
	    try{
			File excelfile = new File("AdvanceSeleniumTestData\\testdata.xlsx");
			FileInputStream fis = new FileInputStream(excelfile);
			  XSSFWorkbook wb=new XSSFWorkbook(fis);
			  XSSFSheet sh1= wb.getSheetAt(0);
			  String username =sh1.getRow(1).getCell(0).getStringCellValue();
			  String password=sh1.getRow(1).getCell(1).getStringCellValue();
		      LoginPage login=new LoginPage(driver);
		      login.loginTohrms(username,password);
		 	  
			
			
		}catch(Exception e){
			System.out.println(e.getMessage());
			
		}
			 
			
			 
			}

}
