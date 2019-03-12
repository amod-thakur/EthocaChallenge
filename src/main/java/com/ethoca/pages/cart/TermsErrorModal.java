package com.ethoca.pages.cart;

import com.ethoca.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TermsErrorModal  extends AbstractPage {
    public TermsErrorModal(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//p[contains(@class,'fancybox-error')]")
    private WebElement termsError;

    @FindBy(xpath = "//a[@title='Close']")
    private WebElement closeTermsErrorBtn;


    public boolean isTermsErrorPresent(){
        wait.until(ExpectedConditions.visibilityOf(termsError));
        return termsError.isDisplayed();
    }


    public CartShippingPage closeTermsError(){
        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.visibilityOf(termsError));
        termsError.click();
        return new CartShippingPage(driver);
    }

    public String getTermsError(){
        return  termsError.getText();
    }
}
