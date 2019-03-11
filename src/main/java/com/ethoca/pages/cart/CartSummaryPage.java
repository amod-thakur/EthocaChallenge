package com.ethoca.pages.cart;

import com.ethoca.utilities.TestUtil;
import com.ethoca.pages.AbstractPage;
import com.ethoca.pages.ButtonsSection;
import com.ethoca.pages.signin.CreateAccountPage;
import com.ethoca.pages.signin.SignInPage;
import org.openqa.selenium.WebDriver;

public class CartSummaryPage extends AbstractPage {

    private ButtonsSection buttonsSection = null;
    public CartSummaryPage(WebDriver driver) {
        super(driver);
        buttonsSection = new ButtonsSection(driver);
    }


    private SignInPage proceedToCheckout(){

        buttonsSection.proceedToCheckOut();
        return new SignInPage(driver);
    }

    public PaymentsPage checkoutAsNewUser(){
        SignInPage signInPage= proceedToCheckout();
        CreateAccountPage createAccountPage =signInPage.createNewAccount();
        CartAddressesPage cartAddressesPage = createAccountPage.registerNewUser(TestUtil.generateUserData());
        cartAddressesPage.proceedToCheckout();
        ShippingPage shippingPage = new ShippingPage(driver);
        return shippingPage.acceptTermsAndCheckout();


    }


}
