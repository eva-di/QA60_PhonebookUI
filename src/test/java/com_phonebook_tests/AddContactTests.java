package com_phonebook_tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        clickOnLoginLink();
        fillRegisterLoginForm(new User().setEmail("guest25@gmail.com").setPassword("Qa12345!"));
        clickOnLoginButton();
    }

    @Test
    public void addContactPositiveTest() {

        clickOnAddLink();
        fillContactForm(new Contact("Zoe", "Jane", "1234567890", "zoe@gmail.com", "Malta, Lemon street 12", "Flight attendant"));
        clickOnSaveButton();
        Assert.assertTrue(isContactAdded("Zoe"));

    }

    @AfterMethod
    public void postCondition() {
        deleteContact();

    }


}
