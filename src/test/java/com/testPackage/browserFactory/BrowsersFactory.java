package com.testPackage.browserFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

/**
 * Created by Kashif on 9/14/2018.
 *
 * This class will contain setup of browsers for testing such as firefox, chrome and IE
 * This class will also initialized Webdriver
 * This class will also launch an application on required browser
 */
public class BrowsersFactory {

    public static WebDriver driver = null;
    SoftAssert softAssert = new SoftAssert();

    public static WebDriver setupBrowser(String browserName, String url){

        if(browserName.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
        }

        else if(browserName.equalsIgnoreCase("chrome")){
            //System.setProperty("webdriver.chrome.driver", "path of the exe file\\chromedriver.exe");
            driver  = new ChromeDriver();
        }

        else {
            driver = new InternetExplorerDriver();
        }

        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;
    }
}
