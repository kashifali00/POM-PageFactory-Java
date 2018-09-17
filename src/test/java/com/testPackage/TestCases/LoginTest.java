package com.testPackage.TestCases;

import com.testPackage.TestCases.testmanager.TestManager;
import com.testPackage.browserFactory.BrowsersFactory;
import com.testPackage.logger.MyLogger;
import com.testPackage.logger.MyLogger;
import com.testPackage.pageFactory.loginPage.LoginPage;

import com.testPackage.pageFactory.loginPage.LogoutPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import sun.rmi.runtime.Log;

/**
 * Created by Kashif on 9/14/2018.
 */
public class LoginTest extends TestManager {

    @Test
    public void login(){

        MyLogger.log.info("Started Executing Login Test");
        logger = report.createTest("Verify user is able to login with valid credentials");
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        LogoutPage logoutPage = PageFactory.initElements(driver,LogoutPage.class);
        loginPage.login("test","test");
        softAssert.assertEquals(logoutPage.submitButton(),"login");
        MyLogger.log.info("Test has been executed Successfully");
        softAssert.assertAll();

    }


}
