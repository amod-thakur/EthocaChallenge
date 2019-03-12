package com.ethoca.tests.listeners;

import com.ethoca.tests.BaseTest;
import com.ethoca.utilities.Log;
import com.ethoca.utilities.TestUtil;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class CustomITestListner extends BaseTest implements ITestListener {
    @Override
    public void onTestStart(ITestResult iTestResult) {
        Log.info("The testMethod "+iTestResult.getName()+" started execution");

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        Log.info("The testMethod "+iTestResult.getName()+" successfully completed execution");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        Log.error("The testMethod "+iTestResult.getName()+" failed execution");
//        Log.error(iTestResult.getThrowable().getMessage());
        Log.error(iTestResult.getThrowable().toString());
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        Log.warn("The testMethod " +iTestResult.getName()+" skipped execution");
//        Log.warn(iTestResult.getThrowable().getMessage());
//        Log.warn(iTestResult.getThrowable().getStackTrace().toString());
        Log.warn(iTestResult.getThrowable().toString());

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
