package com.wipro.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.wipro.base.TestBase;
   
public class RegistrationPage extends TestBase {
	By resgister = By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a");
	By genderRadioBtn = By.id("gender-male");
	By firstName = By.id("FirstName");
	By lastName = By.id("LastName");
	By emailID = By.id("Email");
	By password = By.id("Password");
	By confirmPassword = By.id("ConfirmPassword");
	By registrationButton = By.xpath("//*[@id=\"register-button\"]");
	
	public boolean createAccount(String fname,String lname,String email,String pwd, String confPwd) {
		driver.findElement(resgister).click();
		wait(1000);
		
		driver.findElement(genderRadioBtn).click();
		wait(1000);
		
		driver.findElement(firstName).sendKeys(fname);
		wait(1000);
		
		driver.findElement(lastName).sendKeys(lname);
		wait(1000);
	
		driver.findElement(emailID).sendKeys(email);
		wait(1000);
		
		driver.findElement(password).sendKeys(pwd);
		wait(1000);
		
		driver.findElement(confirmPassword).sendKeys(confPwd);
		wait(1000);
		driver.findElement(registrationButton).click();
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		boolean actResult = true;
		
		try {	
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[2]/a")));
		}catch(TimeoutException te) {
			actResult = false;
			captureScreenshot("Registration failure");
		}
		return actResult;
	}
}
