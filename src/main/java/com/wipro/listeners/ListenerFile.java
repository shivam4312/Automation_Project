package com.wipro.listeners;

import java.io.IOException;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.wipro.base.TestBase;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerFile extends TestBase implements ITestListener {

	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test;

	// Function for starting Listener
	public void onStart(ITestContext context) {
		System.out.println("Test is started");
		htmlReporter = new ExtentHtmlReporter("ExtentReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}

	// Function for finish test
	public void onFinish(ITestContext context) {
		System.out.println("Test is completed");
		extent.flush();
	}

	//Function for Test result
	public void onTestStart(ITestResult result) {
		System.out.println("Execution started for Test Method: " + result.getName());
	}

	// Function for test success
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test is Successful for Test Method: " + result.getName());
		test = extent.createTest(result.getName());
		test.pass(result.getName() + " is Passed");
	}

	// Function for Test Failure
	public void onTestFailure(ITestResult result) {
		System.out.println("Test is Failure for Test Method: " + result.getName());
	String fileName = captureScreenshot(result.getName());
	test = extent.createTest(result.getName());
	try {
		test.fail(result.getName() + " is Failed",MediaEntityBuilder.createScreenCaptureFromPath(fileName).build());
	    test.addScreenCaptureFromPath(".\\Screenshots\\" + fileName);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	}

	// Function for Skipped Test
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test is Skipped for Test Method: " + result.getName());
		test = extent.createTest(result.getName());
		test.skip(result.getName() + " is Skipped");
	}
}	