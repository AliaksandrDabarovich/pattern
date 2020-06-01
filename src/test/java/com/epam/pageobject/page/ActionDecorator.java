package com.epam.pageobject.page;

public abstract class ActionDecorator implements Action {
    private Action action;

    public ActionDecorator(Action action) {
        this.action = action;
    }

    @Override
    public void act() {
        action.act();
    }

}
