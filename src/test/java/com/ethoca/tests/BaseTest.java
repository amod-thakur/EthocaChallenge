package com.ethoca.tests;

import com.ethoca.commons.DriverManagerFactory;
import com.ethoca.pages.LandingPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

/**
 * Base class for all the Test classes. It initializes the driver object, the  base url,sets the page load timeout and contains method to quit driver after execution
 * @author Amod Thakur
 */


public class BaseTest {
	
	
	protected WebDriver driver;
	private final String baseURL = "http://automationpractice.com/index.php";
	protected LandingPage landingPage = null;

	/**
	 * This method is executed before every test method of the child class. It takes the browser type for TestNG Parameter and creates corresponding driver.
	 * @param browser - the type of browser e.g. chrome
	 */
	@Parameters({ "browser" })
	@BeforeMethod
	public void initialise(String browser){
		driver =DriverManagerFactory.getDriver(browser);

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		landingPage = openSite();

	}

	/**
	 * @return an instance of the driver object.
	 */
	public WebDriver getDriver() {
		return driver;
	}

	/**
	 * This method quits the driver object after the test method execution is completed (Passed,Failed,Skipped)
	 */
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

	/**
	 * This method is used to open navigate to the landing page of the application.
	 * @return - a LandingPage obj to allow interaction with the landing page elements.
	 */
	public LandingPage openSite(){
		driver.get(baseURL);

		return new LandingPage(this.driver);
	}
}
