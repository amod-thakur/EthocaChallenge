package com.ethoca.tests;

import java.util.concurrent.TimeUnit;

import com.ethoca.commons.DriverManagerFactory;
import com.ethoca.commons.DriverType;
import com.ethoca.pages.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.ethoca.pages.LandingPage;
import org.testng.annotations.Parameters;

//import io.qameta.allure.Step;

public class BaseTest {
	
	
	protected WebDriver driver;
	private final String baseURL = "http://automationpractice.com/index.php";
	private final String chromeDriverPath = "src/test/resources/lib/chromedriver.exe";

	@Parameters({ "browser" })
	@BeforeMethod
	public void initialise(String browser){
		driver =DriverManagerFactory.getDriver(browser);

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}

	public WebDriver getDriver() {
		return driver;
	}

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

//	@Step("Navigate to the Homepage")
	public LandingPage openSite(){
		driver.get(baseURL);
		return new LandingPage(this.driver);
	}
}
