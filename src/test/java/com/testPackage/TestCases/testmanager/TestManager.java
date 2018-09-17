package com.testPackage.TestCases.testmanager;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.sun.corba.se.spi.activation.ServerManager;
import com.testPackage.browserFactory.BrowsersFactory;
import com.testPackage.logger.MyLogger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import java.io.File;

/**
 * Created by Kashif on 9/17/2018.
 */
public class TestManager {

    public WebDriver driver = null;
    public static SoftAssert softAssert = new SoftAssert();
    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports report;
    public static ExtentTest logger;

    @BeforeTest
    public void setup(){

        MyLogger.log.info("Started Initializing WEB-DRIVER");
        driver = BrowsersFactory.setupBrowser("firefox", "http://newtours.demoaut.com/");
        if(null != driver){
            MyLogger.log.info("Web-driver and application has launched successfully");
        }
        else MyLogger.log.error("ERROR: webdriver or application couldn't launched");

        // setting up the EXTENT-HTML REPORT

        MyLogger.log.info("Creating test-ouput folder for HTML reports");
        File OutputFolder = new File("./test-output");
        if (!OutputFolder.exists()) {
            if(OutputFolder.mkdir()) {
                MyLogger.log.info("test-output directory has created successfully");
            }
            else  {   MyLogger.log.error("FAILED to create test-output directory");
            }
        }else {MyLogger.log.info("Directory already exists");
        }


        report = new ExtentReports();
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/Pliro-Automated-testRun-Report.html");
        report.attachReporter(htmlReporter);

        // Set our document title, theme etc..
        htmlReporter.config().setDocumentTitle("Pliro Test Report");
        htmlReporter.config().setReportName("Pliro Automated Regression Test Run Report");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.DARK);

        report.setSystemInfo("Test", "Regression");
        report.setSystemInfo("APP", "Pilro");
        report.setSystemInfo("User", "Kashif Ali");

    }

    @AfterTest
    public void tearDown(){
        MyLogger.log.info("Test run finished, going to shutdown webdriver");
        driver.manage().deleteAllCookies();
        driver.quit();
        report.flush();
        MyLogger.log.info("Webdriver has been quit successfully");
    }

    @AfterMethod(alwaysRun = true)
    public void getResult(ITestResult result)
    {
        if(result.getStatus()==ITestResult.FAILURE)
        {
            logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "Test Case failed due to below issues", ExtentColor.RED));
            logger.fail(result.getThrowable());
        }

        else if(result.getStatus()== ITestResult.SUCCESS)
        {
            logger.log(Status.PASS, MarkupHelper.createLabel(result.getName() + "Test Case Passed", ExtentColor.GREEN));
        }

        else
        {
            logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + "Test Case skipped", ExtentColor.YELLOW));
        }

    }



}
