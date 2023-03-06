package com.wipro.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.wipro.base.TestBase;

public class HomePage extends TestBase{
	By account = By.xpath("//a[@class='ico-account']");
	By address = By.xpath("/html/body/div[6]/div[3]/div/div[1]/div/div[2]/ul/li[2]/a");
	
	// code for clicking My Account
	public boolean myAccountClick() {
		
		driver.findElement(account).click();
		
		boolean actResult=true;
		try {
			WebDriverWait wait = new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div[1]/h1")));
		}catch(TimeoutException te) {
			actResult=false;
			captureScreenshot("myaccount page failure");
		}
		
		return actResult;
	}
	
	public boolean clickAddress() {
		driver.findElement(address).click();
		wait(1000);
		
		boolean actResult=true;
		
		try {
			WebDriverWait wait = new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div[1]/h1")));
		}catch(TimeoutException te) {
			actResult=false;
			captureScreenshot("address page failure");
		}
		
		return actResult;
	}
}
