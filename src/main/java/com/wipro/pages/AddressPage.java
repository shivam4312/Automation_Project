package com.wipro.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.wipro.base.TestBase;


public class AddressPage extends TestBase{
	
	// Storing web elements by using locators
	
	By addNew = By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div[2]/button");
	By firstName = By.xpath("//*[@id=\"Address_FirstName\"]");
	By lastName = By.xpath("//*[@id=\"Address_LastName\"]");
	By email = By.xpath("//*[@id=\"Address_Email\"]");
	By country = By.xpath("//*[@id=\"Address_CountryId\"]/option[2]");
	By state = By.xpath("//*[@id=\"Address_StateProvinceId\"]/option[10]");
	By city = By.xpath("//*[@id=\"Address_City\"]");
	By address1 = By.xpath("//*[@id=\"Address_Address1\"]");
	By zipCode = By.xpath("//*[@id=\"Address_ZipPostalCode\"]");
	By phoneNumber = By.xpath("//*[@id=\"Address_PhoneNumber\"]");
	By saveBtn = By.xpath("/html/body/div[6]/div[3]/div/div[2]/form/div/div[2]/div[2]/button");
	
	// Function for checking and passing data in web elements
	public boolean addAddress(String firstname,String lastname,String Email,String cityname,String addressCity,String postalCode,String pNumber) {
		
		driver.findElement(addNew).click();
		wait(1000);
		driver.findElement(firstName).sendKeys(firstname);
		wait(1000);
		driver.findElement(lastName).sendKeys(lastname);
		wait(1000);
		driver.findElement(email).sendKeys(Email);
		wait(1000);
		driver.findElement(country).click();
		wait(1000);
		driver.findElement(state).click();
		wait(1000);
		driver.findElement(city).sendKeys(cityname);
		wait(1000);
		driver.findElement(address1).sendKeys(addressCity);
		wait(1000);
		driver.findElement(zipCode).sendKeys(postalCode);
		wait(1000);
		driver.findElement(phoneNumber).sendKeys(pNumber);
		wait(1000);
		driver.findElement(saveBtn).click();
		
		boolean actResult=true;
		try {
			WebDriverWait wait = new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"bar-notification\"]/div/p")));
			driver.findElement(By.className("close")).click();
		}catch(TimeoutException te) {
			actResult=false;
			captureScreenshot("address update failure");
		}
		
		return actResult;
		
	}
	
}
