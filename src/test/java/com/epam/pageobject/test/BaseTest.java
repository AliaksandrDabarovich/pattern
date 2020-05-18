package com.epam.pageobject.test;

import com.epam.pageobject.driver.DriverSingleton;
import com.epam.pageobject.util.TestListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;


@Listeners({TestListener.class})
public class BaseTest {
    protected WebDriver driver;

    protected String sendField = "Self: WebDriver";
    protected String webUrl = "http://mail.ru";



    @BeforeClass
    public void setUp() {

        driver = DriverSingleton.getDriver();
//        driver = new ChromeDriver();
        driver.get(webUrl);
    }

    @AfterClass (alwaysRun = true)
    public void tearDown() {
        DriverSingleton.closeDriver();
//        driver.quit();
//        driver = null;
    }

}
