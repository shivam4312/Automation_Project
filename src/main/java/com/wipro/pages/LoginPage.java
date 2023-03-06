package com.wipro.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.wipro.base.TestBase;
   
public class LoginPage extends TestBase {
	By logIn = By.linkText("Log in");
	By email = By.id("Email");
	By password = By.id("Password");
	By loginButton = By.xpath("//button[text()='Log in']");
	
	// Code For Validating Login Functionality
	public boolean validateLogin(String uname,String pwd) {
		driver.findElement(logIn).click();
		wait(1000);
		driver.findElement(email).sendKeys(uname);
		wait(1000);
		driver.findElement(password).sendKeys(pwd);
		wait(1000);
		driver.findElement(loginButton).click();
		
		// Creating object of webdriverwait
		WebDriverWait wait = new WebDriverWait(driver,10);
		boolean actResult = true;
		
		try {	
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Log out")));
		}catch(TimeoutException te) {
			actResult = false;
			captureScreenshot("login failure");
		}
		return actResult;
	}
}
