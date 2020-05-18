package com.epam.pageobject.util;

import com.epam.pageobject.driver.DriverSingleton;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;

import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TestListener implements ITestListener {
    private Logger log = LogManager.getRootLogger();
    public void onTestStart (ITestListener iTestListener){

    }
    public void onTestSuccess(ITestListener iTestListener){

    }
    public void onTestFailure(ITestListener iTestListener){
        saveScreenshot();
    }
    public void onTestSkipped(ITestListener iTestListener){

    }
    public void onTestFailedButWithinSuccessPercentage(ITestListener iTestListener){

    }
    public void onStart(ITestListener iTestListener){

    }
    public void onFinish(ITestListener iTestListener){

    }
    public void saveScreenshot(){
        File screenCapture = ((TakesScreenshot) DriverSingleton.getDriver())
                .getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(screenCapture, new File (
                    ".//target/screenshots/"
                    + getCurrentTimeAsString() +
                            ".png"));
        } catch (IOException e) {
            log.error("Failed to save screenshot: "+ e.getLocalizedMessage());
        }
    }

    private String getCurrentTimeAsString (){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd_HH-mm-ss");
        return ZonedDateTime.now().format(formatter);
    }

}
