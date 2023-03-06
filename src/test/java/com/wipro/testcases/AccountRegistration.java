package com.wipro.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.wipro.base.TestBase;
import com.wipro.pages.RegistrationPage;

import com.wipro.utilities.ReadFromExcelReg;

public class AccountRegistration extends TestBase{

	@BeforeClass
	public void beforeClass() {
		launchBrowser();
		navigateToURL();
	}

  @Test(dataProvider = "dp")
  public void RegistrationTest(String fname,String lname,String email,String pwd, String confPwd) {
	  RegistrationPage registrationPage = new RegistrationPage();
	  boolean actResult = registrationPage.createAccount(fname,lname,email,pwd,confPwd);
	  Assert.assertTrue(actResult);
  }

  @DataProvider
  public Object[][] dp() {
	  String[][] data = new String[1][5];
	  data = ReadFromExcelReg.getData();
	  return data;
  }
  

  @AfterClass
  public void afterClass() {
	  wait(1000);
	  driver.close();
  }
}
