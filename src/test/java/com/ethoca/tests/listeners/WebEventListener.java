package com.ethoca.tests.listeners;


import com.ethoca.tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;




public class WebEventListener extends BaseTest implements WebDriverEventListener ,ITestListener{


	public void beforeAlertAccept(WebDriver webDriver) {

	}

	public void afterAlertAccept(WebDriver webDriver) {

	}

	public void afterAlertDismiss(WebDriver webDriver) {

	}

	public void beforeAlertDismiss(WebDriver webDriver) {

	}

	public void beforeNavigateTo(String s, WebDriver webDriver) {

	}

	public void afterNavigateTo(String s, WebDriver webDriver) {

	}

	public void beforeNavigateBack(WebDriver webDriver) {

	}

	public void afterNavigateBack(WebDriver webDriver) {

	}

	public void beforeNavigateForward(WebDriver webDriver) {

	}

	public void afterNavigateForward(WebDriver webDriver) {

	}

	public void beforeNavigateRefresh(WebDriver webDriver) {

	}

	public void afterNavigateRefresh(WebDriver webDriver) {

	}

	public void beforeFindBy(By by, WebElement webElement, WebDriver webDriver) {

	}

	public void afterFindBy(By by, WebElement webElement, WebDriver webDriver) {

	}

	public void beforeClickOn(WebElement webElement, WebDriver webDriver) {

		System.out.printf("\nBefore clicking on element %s",webElement);
	}

	public void afterClickOn(WebElement webElement, WebDriver webDriver) {
		System.out.printf("\nBefore clicking on element %s",webElement);
	}

	public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {

	}

	public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {

	}

	public void beforeScript(String s, WebDriver webDriver) {

	}

	public void afterScript(String s, WebDriver webDriver) {

	}

	public void beforeSwitchToWindow(String s, WebDriver webDriver) {

	}

	public void afterSwitchToWindow(String s, WebDriver webDriver) {

	}

	public void onException(Throwable throwable, WebDriver webDriver) {

	}

	public <X> void beforeGetScreenshotAs(OutputType<X> outputType) {

	}

	public <X> void afterGetScreenshotAs(OutputType<X> outputType, X x) {

	}

	public void beforeGetText(WebElement webElement, WebDriver webDriver) {

	}

	public void afterGetText(WebElement webElement, WebDriver webDriver, String s) {

	}

	public void onTestStart(ITestResult iTestResult) {

	}

	public void onTestSuccess(ITestResult iTestResult) {

	}

	public void onTestFailure(ITestResult iTestResult) {

	}

	public void onTestSkipped(ITestResult iTestResult) {

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

	}

	public void onStart(ITestContext iTestContext) {

	}

	public void onFinish(ITestContext iTestContext) {

	}
}