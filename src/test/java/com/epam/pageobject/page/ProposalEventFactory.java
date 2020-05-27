package com.epam.pageobject.page;

public class ProposalEventFactory implements ActionFactory {
    @Override
    public Action createAction(){
        return new ProposalEvent();
    }
}
