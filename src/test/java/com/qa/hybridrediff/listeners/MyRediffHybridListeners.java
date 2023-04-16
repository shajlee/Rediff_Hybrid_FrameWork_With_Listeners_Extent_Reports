package com.qa.hybridrediff.listeners;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.hybridrediff.utilities.RediffHybrid_ExtentReporter;

public class MyRediffHybridListeners implements ITestListener {
	public ExtentReports extentreports;
	public ExtentTest extenttest;
	

	@Override
	public void onStart(ITestContext context) {
		try {
			extentreports = RediffHybrid_ExtentReporter.generateExtentReport();
		} catch (Exception e) {
		    e.printStackTrace();
		}
		//System.out.println("Execution of Rediff Hybrid Project Commenced");
		
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		String testName = result.getName();
		extenttest = extentreports.createTest(testName);
		extenttest.log(Status.INFO, testName + "Started Executing");
		//System.out.println(testName + "Started Executing");
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testName = result.getName();
		extenttest = extentreports.createTest(testName);
		extenttest.log(Status.PASS, testName + "Successfully Executed");
		//System.out.println(testName + "Successfully Executed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName = result.getName();
		WebDriver driver = null;
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\test-output\\Screenshots\\" + testName + ".png";
		try {
			FileHandler.copy(source, new File(destination));
		} catch (IOException e) {
			e.printStackTrace();
		}
		extenttest.addScreenCaptureFromPath(destination);
		extenttest.log(Status.INFO, result.getThrowable());
		extenttest.log(Status.FAIL, testName + "failed");
		//System.out.println(testName + "Failed");
		//System.out.println(result.getThrowable());
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String testName = result.getName();
		extenttest.log(Status.INFO, result.getThrowable());
		extenttest.log(Status.SKIP, testName + "skipped");
		//System.out.println(testName + "got Skipped");
		//System.out.println(result.getThrowable());
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Execution of Rediff Hybrid Project Finished");
		extentreports.flush();
		
		
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		String testName = result.getName();
		System.out.println(testName + "with this much percentage");
		System.out.println(result.getThrowable());
		
		
		
	}
	

}
