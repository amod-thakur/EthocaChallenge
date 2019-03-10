package com.ethoca.pages.cart;

import com.ethoca.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartCommonSection extends AbstractPage {
    public CartCommonSection(WebDriver driver) {
        super(driver);
    }

    @FindBy (className = "home")
    private WebElement homeLink;

    @FindBy(className = "navigation_page")
    private WebElement currentStep;

    @FindBy(className = "page-heading")
    private WebElement pageHeading;


}
