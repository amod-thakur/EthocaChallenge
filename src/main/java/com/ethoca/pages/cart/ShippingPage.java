package com.ethoca.pages.cart;

import com.ethoca.pages.AbstractPage;
import com.ethoca.pages.ButtonsSection;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ShippingPage extends AbstractPage {
    public ShippingPage(WebDriver driver) {
        super(driver);

    }


    @FindBy(id = "cgv")
    private WebElement termsCheckBox;

    @FindBy (xpath = "//button/span[contains(text(),'Proceed')]")
    private WebElement proceedToCheckoutBtn;



    public PaymentsPage acceptTermsAndCheckout(){

        if(!termsCheckBox.isSelected()){
            termsCheckBox.click();
        }
        wait.until(ExpectedConditions.visibilityOf(proceedToCheckoutBtn));
        proceedToCheckoutBtn.click();
        return new PaymentsPage(driver);

    }

}
