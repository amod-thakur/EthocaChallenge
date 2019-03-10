package com.ethoca.pages.cart;

import com.ethoca.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShippingPage extends AbstractPage {
    public ShippingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "cgv")
    private WebElement termsCheckBox;

    public void acceptTerms(){

        if(!termsCheckBox.isSelected()){
            termsCheckBox.click();
        }

    }

}
