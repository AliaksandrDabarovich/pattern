package com.epam.pageobject.page;

public class ProposalWriteHimselfFactory implements ActionFactory {
    @Override
    public Action createAction() {
        return new ProposalWriteHimself();
    }
}
