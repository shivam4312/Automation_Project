package com.wipro.testcases;

import org.testng.annotations.Test;

import com.wipro.base.TestBase;
import com.wipro.pages.LogOut;
import com.wipro.pages.LoginPage;
import com.wipro.pages.PlaceOrderPage;

import com.wipro.utilities.ReadFromExcel;


import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class PlaceOrder extends TestBase {
	@BeforeClass
	public void beforeClass() {
		launchBrowser();
		navigateToURL();
	}

	@Test(dataProvider = "dp")
	public void loginTest(String uname, String pwd) {
		LoginPage loginPage = new LoginPage();
		boolean actResult = loginPage.validateLogin(uname, pwd);
		Assert.assertTrue(actResult);
	}
	 PlaceOrderPage placeOrder;
	  
	  @Test(priority = 1)
	  public void selectDesktopTest() {
		  	placeOrder = new PlaceOrderPage();
			boolean actResult = placeOrder.selectDesktop();
			Assert.assertTrue(actResult);
		}
	  
	  @Test(priority = 2)
	  public void addToCartTest() {
		  	boolean actResult = placeOrder.addToCart();
			Assert.assertTrue(actResult);
		}
	  
	  @Test(priority = 3)
	  public void clickShoppingCartTest() {
		  	boolean actResult = placeOrder.clickShoppingCart();
			Assert.assertTrue(actResult);
		}
	  
	  @Test(priority = 4)
	  public void clickCheckoutTest() {
		  	boolean actResult = placeOrder.clickCheckout();
			Assert.assertTrue(actResult);
		}
	  
	  @Test(priority = 5)
	  public void makePaymentTest() {
		  	boolean actResult = placeOrder.makePayment();
			Assert.assertTrue(actResult);
		}
	  
	  @Test(priority = 6)
	  public void clickConfirmTest() {
		  	boolean actResult = placeOrder.clickConfirm();
			Assert.assertTrue(actResult);
		}  
	  
	@DataProvider
	public Object[][] dp() {

		String[][] data = new String[1][2];
		data = ReadFromExcel.getData();

		return data;
	}

	@Test(priority = 7)
	public void valiadteLogout() {
		LogOut lo = new LogOut();
		boolean actResult = lo.logOut();
		Assert.assertTrue(actResult);
	}
	

	@AfterClass
	public void afterClass() {
		wait(1000);
		driver.close();
	}

}