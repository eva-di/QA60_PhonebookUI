package com.phonebook.tests;

import com.phonebook.models.Contact;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        if(!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutButton();
        }
        app.getUser().clickOnLoginLink();
        app.getUser().fillRegisterLoginForm(new User().setEmail("guest25@gmail.com").setPassword("Qa12345!"));
        app.getUser().clickOnLoginButton();
    }

    @Test
    public void addContactPositiveTest() {

        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(new Contact().setName("Zoe")
                .setLastName("Jane")
                .setPhone("1234567890")
                .setEmail("zoe@gmail.com")
                .setAddress("Malta, Lemon street 12")
                .setDescription("Flight attendant"));
        app.getContact().clickOnSaveButton();
        Assert.assertTrue(app.getContact().isContactAdded("Zoe"));

    }

    @AfterMethod
    public void postCondition() {
        app.getContact().deleteContact();

    }


}
