package com.epam.pageobject.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JSUtils {
    public static void highlightElement(WebDriver driver, WebElement element) {
        String backGroundColor = element.getCssValue("backgroundColor");
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.backgroundColor = '" + "yellow" + "'", element);
        js.executeScript("arguments[0].style.backgroundColor = '" + backGroundColor + "'", element);
    }

    public static void clickJavascript(WebDriver driver, WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }
}
