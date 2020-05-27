package com.epam.pageobject.page;

public class CustomAction implements Action {
    @Override
    public void act() {

        log.info("CustomAction is started");
    }
}
