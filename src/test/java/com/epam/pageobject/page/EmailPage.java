package com.epam.pageobject.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailPage extends AbstractPage {


    @FindBy(xpath = "//a[@href='/sent/']")
    private WebElement sentButton;
    @FindBy(xpath = "//a[contains(@class, 'compose-button')]")
    private WebElement composeButton;
    @FindBy(xpath = "//a[@href='/drafts/']")
    private WebElement draftsButton;

    public EmailPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getSentButton() {
        return waitForVisibility(sentButton);
    }

    public ComposeEmailPage composeEmailFromEmailPage() {
        waitForVisibility(composeButton).click();
        return new ComposeEmailPage(driver);
    }

    public DraftsPage openDraftsPageFromEmailPage() {
        moveClick(driver, draftsButton);
        return new DraftsPage(driver);
    }
}
