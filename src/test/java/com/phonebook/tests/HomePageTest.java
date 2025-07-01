package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if(!app.getHome().isHomeComponentPresent()) {
            app.getHome().clickOnHomeLink();
        }
    }
    @Test
    public void isHomeComponentPresentTest() {
        Assert.assertTrue(app.getHome().isHomeComponentPresent());
    }

    public boolean isHomeComponentPresent() {
        return false;
    }

}
