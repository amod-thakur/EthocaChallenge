package com.ethoca.commons;

import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


/**
 * This class acts as a factor class to instantiate the driver object to appropriate driver based on the value supplied to getDriver() method
 * @author Amod Thakur
 *
 */
public class DriverManagerFactory {
    private static WebDriver driver;

    private DriverManagerFactory(){

    }

    /**
     * This method instantiates respective driver object
     * @param browser the browser type e.g. chrome
     * @return an object of the respective driver
     */
    public static WebDriver getDriver(String browser) {

        DriverType driverType = DriverType.valueOf(browser.toUpperCase());

        switch (driverType) {
            case CHROME:
                /**
                 * Uses WebDriverManager project to automatically manage the binary driver
                 *  https://github.com/bonigarcia/webdrivermanager
                 */
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case FIREFOX:
                /**
                 * Uses WebDriverManager project to automatically manage the binary driver
                 *  https://github.com/bonigarcia/webdrivermanager
                 */
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

        }


        return driver;

    }
}
