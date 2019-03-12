package com.ethoca.pages.cart;

import com.ethoca.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartShippingPage extends AbstractPage {
    public CartShippingPage(WebDriver driver) {
        super(driver);

    }


    @FindBy(id = "cgv")
    private WebElement termsCheckBox;

    @FindBy (xpath = "//button/span[contains(text(),'Proceed')]")
    private WebElement proceedToCheckoutBtn;

    @FindBy(xpath = "//h1[contains(text(),'Shipping')]")
    private WebElement shippingTitle;

    public CartPaymentsPage acceptTermsAndCheckout(){

        if(!termsCheckBox.isSelected()){
            termsCheckBox.click();
        }
        wait.until(ExpectedConditions.visibilityOf(proceedToCheckoutBtn));
        proceedToCheckoutBtn.click();
        return new CartPaymentsPage(driver);

    }

    public Boolean isShippingTitlePresent(){

        return shippingTitle.isDisplayed();
    }

    public TermsErrorModal proceedUncheckedTermsError(){
        wait.until(ExpectedConditions.visibilityOf(proceedToCheckoutBtn));
        proceedToCheckoutBtn.click();
        return new TermsErrorModal(driver);

    }

    public CartShippingPage closeTermModalError(){
        wait.until(ExpectedConditions.visibilityOf(proceedToCheckoutBtn));
        TermsErrorModal termsErrorModal = proceedUncheckedTermsError();
        termsErrorModal.closeTermsError();

        return new CartShippingPage(driver);

    }


}
