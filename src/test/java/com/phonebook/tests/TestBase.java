package com.phonebook.tests;

import com.phonebook.fw.ApplicationManager;
import org.openqa.selenium.remote.Browser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.util.Arrays;


public class TestBase {
    Logger logger = LoggerFactory.getLogger(TestBase.class);

    protected static ApplicationManager app =
            new ApplicationManager(System.getProperty("browser", Browser.CHROME.browserName()));

    //@BeforeMethod
    @BeforeSuite
    public void setUp() {
        app.init();
    }

    //@AfterMethod(enabled = false)
    @AfterSuite
    public void tearDown() {

        app.stop();
    }

    @BeforeMethod
    public void startTest(Method method, Object[] p) {
        logger.info("Start test: " + method.getName() + Arrays.asList(p));
    }

    @AfterMethod
    public void stopTest(ITestResult result) {
        if(result.isSuccess()) {
            logger.info("PASSED: " + result.getMethod().getMethodName());
        } else {
            logger.error("FAILED: " + result.getMethod()
                    .getMethodName() + " Screenshot path: " + app.getUser()
                    .takeScreenShot());
        }
        logger.info("Stop test");
        logger.info("=====================================================");
    }



}
