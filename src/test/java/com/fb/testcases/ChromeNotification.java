package com.fb.testcases;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.ChromeDriverManager;

public class ChromeNotification {
	public static void main(String[] args) throws Exception {
       
Map<String, Object> prefs = new HashMap<String, Object>();    
prefs.put("profile.default_content_setting_values.notifications", 2);
ChromeOptions options = new ChromeOptions();      
options.setExperimentalOption("prefs", prefs);
ChromeDriverManager.getInstance().setup();
WebDriver driver = new ChromeDriver(options);	
//driver.get("http://www.yatra.com/");
driver.get("https://www.redbus.in/");
Reporter.log("notification handeled");
//driver.close();


}
}
