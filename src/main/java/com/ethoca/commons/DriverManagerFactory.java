package com.ethoca.commons;

import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverManagerFactory {
    private static WebDriver driver;

    public static WebDriver getDriver(String browser) {

        DriverType driverType = DriverType.valueOf(browser.toUpperCase());

        switch (driverType) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"src/test/resources/geckodriver.exe");
//                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;

    }
}
