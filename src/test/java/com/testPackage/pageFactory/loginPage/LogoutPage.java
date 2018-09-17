package com.testPackage.pageFactory.loginPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;


/**
 * Created by Kashif on 9/17/2018.
 */
public class LogoutPage {

    @CacheLookup
    @FindBy(css = "input[value='Login']")
    WebElement SubmitButton;

    public String submitButton(){
        return SubmitButton.getAttribute("name");
    }
}
