package com.wipro.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.wipro.base.TestBase;
import com.wipro.utilities.WriteIntoFile;

public class PlaceOrderPage extends TestBase{
	By clickOnComp = By.xpath("/html/body/div[6]/div[2]/ul[1]/li[1]/a");
	By clickOnDesktop = By.xpath("/html/body/div[6]/div[3]/div/div[2]/div[1]/div[2]/ul/li[1]/ul/li[1]/a");
	By fetchProdName = By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[2]/div/div[2]/h2/a");
	By fetchProdPrice = By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[2]/div/div[2]/div[3]/div[1]/span");
	By clickOnAddToCart = By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[2]/div/div[2]/div[3]/div[2]/button[1]");
	By clickOnShoppingCart = By.cssSelector("#topcartlink > a");
	By clickCheckBox = By.xpath("//*[@id=\"termsofservice\"]");
	By checkOut = By.xpath("//*[@id=\"checkout\"]");
	
	By shoppingCartTextCheck = By.xpath("/html/body/div[6]/div[3]/div/div/div/div[1]/h1");

	
	
	By clickContinue = By.xpath("//*[@id=\"billing-buttons-container\"]/button[4]");
	By shipContinue = By.xpath("//*[@id=\"shipping-method-buttons-container\"]/button");
	By paymentContinue = By.xpath("//*[@id=\"payment-method-buttons-container\"]/button");
	By paymentInfoContinue = By.xpath("//*[@id=\"payment-info-buttons-container\"]/button");
	By cnfBtn = By.xpath("//*[@id=\"confirm-order-buttons-container\"]/button");
	By cnfMsg = By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div/div[1]/strong");
	
WebDriverWait wait = new WebDriverWait(driver, 10);
	
	// code for select desktop
	public boolean selectDesktop() {
		driver.findElement(clickOnComp).click();
		wait(2000);
		driver.findElement(clickOnDesktop).click();
		wait(3000);
		//fetching product name & price and storing it in text file
		String ProductName = driver.findElement(fetchProdName).getText();
		String ProductPrice = driver.findElement(fetchProdPrice).getText();
		
		WriteIntoFile.writeData(ProductName, ProductPrice);
		boolean actResult = driver.findElement(clickOnAddToCart).isDisplayed();
		return actResult;
	}
	
	// function for adding product into cart
	public boolean addToCart() {
		driver.findElement(clickOnAddToCart).click();
		wait(20000);
		boolean actResult = driver.findElement(clickOnShoppingCart).isDisplayed();
		return actResult;
	}

	// function for clicking Shopping Cart
	public boolean clickShoppingCart() {
		driver.findElement(clickOnShoppingCart).click();
		wait(1000);
		driver.findElement(clickCheckBox).click();
		wait(1000);
		boolean actResult = driver.findElement(shoppingCartTextCheck).isDisplayed();
		return actResult;
	}
	
	// Function for clicking checkout
	public boolean clickCheckout() {
		driver.findElement(checkOut).click();
		wait(1000);
		driver.findElement(clickContinue).click();
		wait(1000);
		driver.findElement(shipContinue).click();
		wait(5000);
		boolean actResult = driver.findElement(paymentContinue).isDisplayed();
		return actResult;
		
	}
	// Function for make Payment
	public boolean makePayment() {
		driver.findElement(By.xpath("//*[@id=\"paymentmethod_0\"]")).click();
		driver.findElement(paymentContinue).click();
		wait(1000);
		driver.findElement(paymentInfoContinue).click();
		wait(5000);
		boolean actResult = driver.findElement(cnfBtn).isDisplayed();
		return actResult;
		
	}

	// function for click confirm
	public boolean clickConfirm() {
		driver.findElement(cnfBtn).click();
		wait(1000);
		boolean actResult = true;
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(cnfMsg));
		} catch (TimeoutException te) {
			actResult = false;
			captureScreenshot("login failure");
		}

		return actResult;
		
	}
	

}