package com.ethoca.pages;

import Utilities.TestUtil;
import com.ethoca.pages.cart.CartSection;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HeaderSection extends AbstractPage{


    public HeaderSection(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath ="//a[@title='View my shopping cart']")
    private WebElement cartMenu;

    @FindBy(xpath = "//a[@title='Women']")
    private WebElement womenMegaMenu;


    public CartSection openCartMenu(){
//        driver.switchTo().parentFrame();
        wait.until(ExpectedConditions.visibilityOf(cartMenu));
        TestUtil.hoverOverElement(cartMenu,driver);

        return new CartSection(driver);
    }

    public WomenMegaMenu openWomenMegaMenu(){
        TestUtil.hoverOverElement(womenMegaMenu,driver);


        return new WomenMegaMenu(driver);
    }
}
