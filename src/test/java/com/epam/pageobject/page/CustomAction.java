package com.epam.pageobject.page;

public class CustomAction extends ActionDecorator {

    public CustomAction(Action action) {
        super(action);
    }

    public void act() {
        super.act();
        log.info("Decorator works");
    }
}
