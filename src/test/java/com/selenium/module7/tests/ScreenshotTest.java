package com.selenium.module7.tests;


import com.selenium.module7.utility.ScreenshotOnTestFailListner;
import com.selenium.module7.patterns.SingletonDriverManager;
import com.selenium.module7.utility.Log;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

@Listeners(ScreenshotOnTestFailListner.class)
public class ScreenshotTest {
    private static final String USERNAME = "testautomationuser";

    @Test
    public void oneCanTakeScreenshotOnFailureTest() {
        WebDriver driver = SingletonDriverManager.getWebDriverInstance();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.github.com/");
        Log.info("Opened github");
        driver.findElement(By.xpath("//a[text()='Sign in']")).click();
        Log.info("Clicked on signin button");
        driver.findElement(By.xpath("//input[@id='login_field']")).sendKeys(USERNAME);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Time4Death!");
        Log.debug("Entered password");
        Log.debug("Going to click on signin button");
        driver.findElement(By.xpath("//WRONG_LOCATOR']")).click();
        String loggedInUserName = driver.findElement(By.xpath("//button[@aria-label='Switch account context']/span")).getText();
        Assert.assertEquals(USERNAME, loggedInUserName);
        SingletonDriverManager.closeWebBrowser();
    }



}