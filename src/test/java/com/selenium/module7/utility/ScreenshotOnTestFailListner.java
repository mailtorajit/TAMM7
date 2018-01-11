package com.selenium.module7.utility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.*;
import com.selenium.module7.patterns.SingletonDriverManager;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.selenium.module7.utility.Log;

public class ScreenshotOnTestFailListner implements ITestListener, ISuiteListener, IInvokedMethodListener {

	public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {

	}

	public void afterInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {

	}

	public void onStart(ISuite iSuite) {

	}

	public void onFinish(ISuite iSuite) {

	}

	public void onTestStart(ITestResult iTestResult) {

	}

	public void onTestSuccess(ITestResult iTestResult) {

	}

	public void onTestFailure(ITestResult iTestResult) {
		takeScreenshot();
	}

	public void onTestSkipped(ITestResult iTestResult) {

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

	}

	public void onStart(ITestContext iTestContext) {

	}

	public void onFinish(ITestContext iTestContext) {

	}

	private void takeScreenshot() {
		Log.error("Taking screenshot on erro");
		File screenCapture = ((TakesScreenshot) SingletonDriverManager.getWebDriverInstance())
				.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenCapture, new File(".//target/screenshots/screenshot_" + getTimeStamp() + ".png"));
		} catch (IOException e) {
			System.out.println("Failed to save screenshot: " + e.getLocalizedMessage());
		}
	}

	private String getTimeStamp() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		Date date = new Date();
		return dateFormat.format(date);
	}
}
