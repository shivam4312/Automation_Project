package com.wipro.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.wipro.base.TestBase;

public class LogOut extends TestBase{
	By logout = By.xpath("//a[@class='ico-logout']");
	WebDriverWait wait = new WebDriverWait(driver,10);
	public boolean logOut() {
		wait(5000);
		driver.findElement(logout).click();
		
		boolean actResult=true;
		try {
//			WebDriverWait wait = new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")));
		}catch(TimeoutException te) {
			actResult=false;
			captureScreenshot("logout failure");
		}
		
		return actResult;
	}
}
