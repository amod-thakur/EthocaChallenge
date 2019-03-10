package com.ethoca.tests;

import java.util.concurrent.TimeUnit;

import com.ethoca.pages.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.ethoca.pages.LandingPage;

//import io.qameta.allure.Step;

public class BaseTest {
	
	
	protected WebDriver driver;
//	private Properties prop;
	private final String baseURL = "http://automationpractice.com/index.php";
	private final String chromeDriverPath = "src/test/resources/lib/chromedriver.exe";
	
	
//	public BaseTest(){
//		try {
//		prop = new Properties();
//		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/config.properties");
//		
//			prop.load(fis);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		String browser = prop.getProperty("browser");
//		this.driver = new CustomDriver(browser);
		
		
//	}
	
	@BeforeMethod
	public void initialise(){
//		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
////		driver = new ChromeDriver();
//		ChromeOptions chromeOptions = new ChromeOptions();
////		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
//		chromeOptions.addArguments("--headless");
//		chromeOptions.addArguments("--disable-gpu");
//		driver = new ChromeDriver(chromeOptions);

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
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
