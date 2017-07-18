package com.fb.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.EdgeDriverManager;

public class MicrosoftEdgeTest {

	public WebDriver driver;
	
	@Test
	public void launchBrowser() {
		System.out.println("launching Microsoft Edge browser");
		System.setProperty("webdriver.edge.driver","C:\\Program Files (x86)\\Microsoft Web Driver\\MicrosoftWebDriver.exe");
		//EdgeDriverManager.getInstance().setup();
		driver = new EdgeDriver();
		driver.get("https://google.com");
		System.out.println("opening google.....");
	}
}
