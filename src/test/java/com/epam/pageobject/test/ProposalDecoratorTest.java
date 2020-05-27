package com.epam.pageobject.test;

import com.epam.pageobject.model.User;
import com.epam.pageobject.page.ActionPage;
import com.epam.pageobject.page.EmailLoginPage;
import com.epam.pageobject.page.EmailPage;
import com.epam.pageobject.service.UserCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProposalDecoratorTest extends BaseTest{
    @Test
    public void testProposal() {

        User testUser = UserCreator.withCredentialsFromProperty();
        EmailLoginPage emailLoginPage = new EmailLoginPage(driver);
        EmailPage emailPage = emailLoginPage.inputCredentials(testUser);
        ActionPage actionPage = emailPage.openDecoratorAction();
        Assert.assertTrue(actionPage.checkAction() != null, "Action was not performed");

    }
}
