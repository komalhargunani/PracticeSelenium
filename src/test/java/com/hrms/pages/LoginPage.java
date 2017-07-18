package com.hrms.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {
	
	WebDriver driver;
	By username=By.name("txtUsername");
	By password=By.name("txtPassword");
	By loginButton=By.id("btn-login");
	 
	 
	public LoginPage(WebDriver driver)
	{
	this.driver=driver;
	}
	 
	 
	public void loginTohrms(String userid,String pass)
	{
	 
	driver.findElement(username).sendKeys(userid);
	driver.findElement(password).sendKeys(pass);
	
	System.out.println("===================="+loginButton);
	driver.findElement(loginButton).click();
	}
	 
	
 
}
