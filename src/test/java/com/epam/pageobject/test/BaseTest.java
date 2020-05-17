package com.epam.pageobject.test;

import com.epam.pageobject.driver.DriverSingleton;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;


public class BaseTest {
    protected WebDriver driver;

    protected String sendField = "Self: WebDriver";
    protected String hubUrl = "http://localhost:4444/wd/hub";
    protected String webUrl = "http://mail.ru";



    @BeforeClass
    public void setUp() {

        driver = DriverSingleton.getDriver();
        driver.get(webUrl);
    }

    @AfterClass (alwaysRun = true)
    public void tearDown() {
        DriverSingleton.closeDriver();
    }

}
