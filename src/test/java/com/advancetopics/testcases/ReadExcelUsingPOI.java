package com.advancetopics.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fb.testcases.CommonUtility;
import com.hrms.pages.LoginPage;
import com.hrms.synerzip.Constants;



public class ReadExcelUsingPOI {

	WebDriver driver;
	Properties prop;
	
	
	@BeforeMethod()
	public void setup(){
		
     //driver=CommonUtility.setupFirefoxBrowser();
		
	}
	
	@Test()
	public void readJxlData()
	{
		
		//driver.get(Constants.URL);
		
	   // driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	
	    try{
			File excelfile = new File("AdvanceSeleniumTestData\\numericdata.xlsx");
			FileInputStream fis = new FileInputStream(excelfile);
			  XSSFWorkbook wb=new XSSFWorkbook(fis);
			  //XSSFSheet sh1= wb.getSheetAt(0); 
			  int data= (int)wb.getSheetAt(0).getRow(0).getCell(1).getNumericCellValue();
			//String data= wb.getSheetAt(0).getRow(0).getCell(1).getStringCellValue();
			  System.out.println("Data from Excel is >>> "+data);
			
			
		}catch(Exception e){
			System.out.println(e.getMessage());
			
		}
			 
			
			 
			}

}
