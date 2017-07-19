package com.hrms.testcases;


//package com.hrms.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.hrms.pages.LoginPage;
import com.hrms.synerzip.Constants;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;


public class VerifyHrmsLogin {
	WebDriver driver;
	
	
	@Parameters("browser")
	  @BeforeClass
	  
	  
	 
	  
	 public void beforeTest(String browser) {
		
		
		if(browser.equalsIgnoreCase("chrome")) {
			
			//System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			ChromeDriverManager.getInstance().setup();
			
			  driver = new ChromeDriver();
			  driver.get(Constants.URL); 
			  driver.manage().window().maximize();
			  driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		}else if(browser.equalsIgnoreCase("ie")){
			 // System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
			  InternetExplorerDriverManager.getInstance().setup();
			  //DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			 // capabilities.setCapability("requireWindowFocus", true);
			//  capabilities.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
			 // driver = new InternetExplorerDriver(capabilities);
			  driver = new InternetExplorerDriver();
			  driver.get(Constants.URL); 
			  driver.manage().window().maximize();
			  driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			  driver.manage().window().setSize(new Dimension(1024,768));
		}else if(browser.equalsIgnoreCase("firefox")){
			// System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			FirefoxDriverManager.getInstance().setup();
			 
			 DesiredCapabilities capabilities=DesiredCapabilities.firefox();
				capabilities.setCapability("marionette", true);
				driver = new FirefoxDriver(capabilities);
				driver.get(Constants.URL);
				driver.manage().window().maximize();
			    driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
				
		}
		
		
		
	}
	  
	  @Test
 
	public void verifyValidLogin() throws Exception
	{
	 
		
		  File src=new File("hrms\\testdata.xlsx");
		 
		
		   FileInputStream fis=new FileInputStream(src);
		 
		   XSSFWorkbook wb=new XSSFWorkbook(fis);
		  
		      XSSFSheet sh1= wb.getSheetAt(0);
	 
		      String username =sh1.getRow(1).getCell(0).getStringCellValue();
			  String password=sh1.getRow(1).getCell(1).getStringCellValue();
	 
	LoginPage login=new LoginPage(driver);
	 
	 
	 
	login.loginTohrms(username,password);
	 
	 
	
	 
	}
	
	 
	  @AfterClass
	  public void afterTest() {
	 
		driver.quit();
	 
		
}
}
