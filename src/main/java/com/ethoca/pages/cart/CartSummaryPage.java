package com.ethoca.pages.cart;

import com.ethoca.utilities.TestUtil;
import com.ethoca.pages.AbstractPage;
import com.ethoca.pages.ButtonsSection;
import com.ethoca.pages.signin.CreateAccountPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartSummaryPage extends AbstractPage {

    private ButtonsSection buttonsSection = null;
    public CartSummaryPage(WebDriver driver) {
        super(driver);
        buttonsSection = new ButtonsSection(driver);
    }
    @FindBy(id = "cart_title")
    private WebElement summaryPgTitle;


    public CartSignInPage proceedToCheckout(){

        buttonsSection.proceedToCheckOut();
        return new CartSignInPage(driver);
    }

    public CartPaymentsPage checkoutAsNewUser(){
        CartSignInPage cartSignInPage = proceedToCheckout();
        CreateAccountPage createAccountPage = cartSignInPage.createNewAccount();
        CartAddressesPage cartAddressesPage = createAccountPage.registerNewUser(TestUtil.generateUserData());
        cartAddressesPage.proceedToCheckout();
        CartShippingPage cartShippingPage = new CartShippingPage(driver);
        return cartShippingPage.acceptTermsAndCheckout();


    }

    public Boolean isSummaryPgTitlePresent(){
        return  summaryPgTitle.isDisplayed();
    }


}
