package com_phonebook_tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTest extends TestBase {

    @Test(enabled = false)
    public void newUserRegistrationPositiveTest() {
        int i = (int)((System.currentTimeMillis()/ 1000)%3600); // метод, который генерирует новые email

        clickOnLoginLink();
        fillRegisterLoginForm(new User().setEmail("guest25@gmail.com").setPassword("Qa12345!"));
        clickOnRegistrationButton();
        Assert.assertTrue(isSignOutButtonPresent());
    }

    @Test
    public void existedUserRegistrationNegativeTest() {
        clickOnLoginLink();
        fillRegisterLoginForm(new User().setEmail("guest25@gmail.com").setPassword("Qa12345!"));
        clickOnRegistrationButton();
        Assert.assertTrue(isAlertDisplayed());
        }

}
