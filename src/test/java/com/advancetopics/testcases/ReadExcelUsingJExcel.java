package com.advancetopics.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fb.testcases.CommonUtility;
import com.hrms.pages.LoginPage;
import com.hrms.synerzip.Constants;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class ReadExcelUsingJExcel {
	
	WebDriver driver;
	Properties prop;
	
	
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
			File excelfile = new File("AdvanceSeleniumTestData\\jexceldata.xls");
			FileInputStream fis = new FileInputStream(excelfile);
			Workbook wb=Workbook.getWorkbook(fis);
			Sheet sh1= wb.getSheet(0);
			Cell  c1=sh1.getCell(0,0);
			String username=c1.getContents();
			Cell  c2=sh1.getCell(0,1);
			String password=c2.getContents();
		    LoginPage login=new LoginPage(driver);
		    login.loginTohrms(username,password);
		 	  
			
			
		}catch(Exception e){
			System.out.println(e.getMessage());
			
		}
			 
			
			 
			}
	}


