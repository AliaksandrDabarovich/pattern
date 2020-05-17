package com.epam.pageobject.test;

import com.epam.pageobject.driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;




public class BaseTest {
    protected WebDriver driver;

    protected String sendField = "Self: WebDriver";
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
