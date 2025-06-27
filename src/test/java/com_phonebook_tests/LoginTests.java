package com_phonebook_tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @Test
    public void loginPositiveTest() {

        clickOnLoginLink();
        fillRegisterLoginForm(new User().setEmail("guest25@gmail.com").setPassword("Qa12345!"));
        clickOnLoginButton();
        Assert.assertTrue(isSignOutButtonPresent());
    }

    @Test
    public void loginNegativeTest() {

        clickOnLoginLink();
        fillRegisterLoginForm(new User().setPassword("Qa12345!"));
        clickOnLoginButton();
        Assert.assertTrue(isAlertDisplayed());
    }

}
