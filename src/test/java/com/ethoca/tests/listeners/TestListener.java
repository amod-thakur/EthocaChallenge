package com.ethoca.tests.listeners;

import com.ethoca.report.ExtentManager;
import com.ethoca.report.ExtentTestManager;
import com.ethoca.tests.BaseTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener extends BaseTest implements ITestListener {

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    //Before starting all tests, below method runs.

    public void onStart(ITestContext iTestContext) {

        iTestContext.setAttribute("WebDriver", this.driver);
    }

    //After ending all tests, below method runs.

    public void onFinish(ITestContext iTestContext) {

        //Do tier down operations for extentreports reporting!
        ExtentTestManager.endTest();
        ExtentManager.getReporter().flush();
    }


    public void onTestStart(ITestResult iTestResult) {

        //Start operation for extentreports.
        ExtentTestManager.startTest(iTestResult.getMethod().getMethodName(),"");
    }


    public void onTestSuccess(ITestResult iTestResult) {

        //Extentreports log operation for passed tests.
        Object testClass = iTestResult.getInstance();
        WebDriver webDriver = ((BaseTest) testClass).getDriver();
        String base64Screenshot = "data:image/png;base64,"+((TakesScreenshot)webDriver).
                getScreenshotAs(OutputType.BASE64);
        ExtentTestManager.getTest().log(LogStatus.PASS, "Test passed",ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));
    }


    public void onTestFailure(ITestResult iTestResult) {


        //Get driver from BaseTest and assign to local webdriver variable.
        Object testClass = iTestResult.getInstance();
        WebDriver webDriver = ((BaseTest) testClass).getDriver();

        //Take base64Screenshot screenshot.
        String base64Screenshot = "data:image/png;base64,"+((TakesScreenshot)webDriver).
                getScreenshotAs(OutputType.BASE64);

        //Extentreports log and screenshot operations for failed tests.
        ExtentTestManager.getTest().log(LogStatus.FAIL,"Test Failed",
                ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));
    }


    public void onTestSkipped(ITestResult iTestResult) {

        //Extentreports log operation for skipped tests.
        ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Skipped");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }
}
