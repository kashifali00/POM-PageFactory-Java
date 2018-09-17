package com.testPackage.pageFactory.loginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Kashif on 9/14/2018.
 *
 * This class will contain all the locators present on login page
 * This class will also contains methods to login
 */
public class LoginPage {

    @CacheLookup
    @FindBy(name = "userName")
    WebElement userName;

    @CacheLookup
    @FindBy(css = "input[type='text']")
    WebElement uName;


    @CacheLookup
    @FindBy(name = "password")
    WebElement password;

    @CacheLookup
    @FindBy(css = "input[type='password']")
    WebElement userPassword;

    @CacheLookup
    @FindBy(css = "input[value='Login']")
    WebElement loginButton;


    public void login(String username, String password){
        userName.sendKeys(username);
        userPassword.sendKeys(password);
        loginButton.click();


    }

}
