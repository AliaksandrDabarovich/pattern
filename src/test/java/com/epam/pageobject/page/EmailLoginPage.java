package com.epam.pageobject.page;


import com.epam.pageobject.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class EmailLoginPage extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();
    @FindBy(xpath = "//*[@id='mailbox:login']")
    private WebElement inputEmailField;
    @FindBy(css = "input.o-control")
    private WebElement inputPasswordButton;
    @FindBy(id = "mailbox:password")
    private WebElement inputPasswordField;
    @FindBy(xpath = "//input[@class='o-control']")
    private WebElement inputEnterButton;


    public EmailLoginPage(WebDriver driver) {
        super(driver);
    }

    public EmailPage inputCredentials(User user) {

        waitForVisibility(inputEmailField);
        highlightElement(driver, inputEmailField);
        performActionSendkeys(driver, inputEmailField, user.getUsername());
        inputPasswordButton.click();
        waitForVisibility(inputPasswordField);
        highlightElement(driver, inputPasswordField);
        inputPasswordField.sendKeys(user.getPassword());
        clickJavascript(driver, inputEnterButton);
        logger.info("User logged in");
        return new EmailPage(driver);
    }


}
