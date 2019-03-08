package com.ethoca.pages.cart;

import com.ethoca.pages.AbstractPage;
import com.ethoca.pages.ButtonsSection;
import com.ethoca.pages.signin.SignInPage;
import org.openqa.selenium.WebDriver;

public class CartSummaryPage extends AbstractPage {

    private ButtonsSection buttonsSection = null;
    public CartSummaryPage(WebDriver driver) {
        super(driver);
        buttonsSection = new ButtonsSection(driver);
    }


    public SignInPage proceedToCheckout(){
        buttonsSection.proceedToCheckOut();
        return new SignInPage(driver);
    }


}
