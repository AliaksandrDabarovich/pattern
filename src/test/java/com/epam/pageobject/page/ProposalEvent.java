package com.epam.pageobject.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProposalEvent implements Action {
    @FindBy(xpath = "//span[contains(text(),'Создать событие')]")
    WebElement event;

    public void act() {
        log.info("Action is started");
    }
}

