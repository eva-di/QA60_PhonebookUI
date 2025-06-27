package com_phonebook_tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteContactTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        clickOnLoginLink();
        fillRegisterLoginForm(new User().setEmail("guest25@gmail.com").setPassword("Qa12345!"));
        clickOnLoginButton();
        clickOnAddLink();
        fillContactForm(new Contact("Zoe", "Jane", "1234567890", "zoe@gmail.com", "Malta, Lemon street 12", "Flight attendant"));
        clickOnSaveButton();
    }
    @Test
    public void deleteContactTest() {

        int sizeBefore = sizeOfContacts();
        deleteContact();
        pause(1000);
        int sizeAfter = sizeOfContacts();
        Assert.assertEquals(sizeAfter, sizeBefore - 1);
    }

}
