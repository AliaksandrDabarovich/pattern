package com.epam.pageobject.page;

public class ActionDecorator implements Action{
Action action;
public ActionDecorator (Action action){
    this.action = action;
}
public void act(){
    action.act();
    log.info("Decorator works");
}

}
