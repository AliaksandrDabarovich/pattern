package com.epam.pageobject.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

public abstract class AbstractPage {
    protected WebDriver driver;
    protected final int WAIT_TIMEOUT_SECONDS = 10;
    protected final String SUBJECT = "WebDriver";
    protected final String BODY = "Text for test";


    protected AbstractPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    protected WebElement waitForVisibility(WebElement element) {
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(element));

    }

    protected WebElement fluentWaitForVisibility(WebElement element) {
        return new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(WAIT_TIMEOUT_SECONDS)).pollingEvery(Duration.ofSeconds(WAIT_TIMEOUT_SECONDS)).ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.visibilityOf(element));

    }


    protected WebElement waitElement(WebElement webElement) {
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(webElement));

    }

    protected WebElement waitTillElementClickable(WebElement element) {
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(element));
    }

    public void highlightElement(WebDriver driver, WebElement element) {
        String backGroundColor = element.getCssValue("backgroundColor");
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.backgroundColor = '" + "yellow" + "'", element);
        js.executeScript("arguments[0].style.backgroundColor = '" + backGroundColor + "'", element);
    }

    public void clickJavascript(WebDriver driver, WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public void moveClick(WebDriver driver, WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).click().perform();
    }


    public void performActionSendkeys(WebDriver driver, WebElement element, String string) {
        Actions action = new Actions(driver);
        action.click(element).sendKeys(string).perform();
    }

//    public String getEmail() {
//        return EMAIL;
//    }

    public String getSubject() {
        return SUBJECT;
    }

    public String getBody() {
        return BODY;
    }

//    public String getPassword() {
//        return PASSWORD;
//    }


}
