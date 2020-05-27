package com.epam.pageobject.page;

public class ProposalCallFactory implements ActionFactory {
    @Override
    public Action createAction() {
        return new ProposalCall();
    }
}
