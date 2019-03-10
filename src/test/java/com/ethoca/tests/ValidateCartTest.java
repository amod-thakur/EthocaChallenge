package com.ethoca.tests;

import Utilities.TestUtil;
import com.ethoca.pages.HeaderSection;
import com.ethoca.pages.LandingPage;
import com.ethoca.pages.SummerDressesPage;
import com.ethoca.pages.WomenMegaMenu;
import com.ethoca.pages.cart.*;
import com.ethoca.pages.signin.Addresses;
import com.ethoca.pages.signin.CreateAccountPage;
import com.ethoca.pages.signin.SignInPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class ValidateCartTest extends BaseTest {
    LandingPage landingPgObj = null;
    WomenMegaMenu womenMegaMenu = null;
    SummerDressesPage summerDressesPage = null;

    @BeforeMethod
    public void setup() {
        landingPgObj = openSite();
    }

    @Test
    public void validateCartDetails(){

        womenMegaMenu =landingPgObj.navigateToWomenMegaMenu();
        summerDressesPage=  womenMegaMenu.selectSummerDresses();
        CartDialog cartDialog = summerDressesPage.addDressToCart("M");
        landingPgObj =cartDialog.continueShopping();
        CartSection cartSection= landingPgObj.viewCart();
        CartSummaryPage cartSummaryPage= cartSection.checkout();
        SignInPage signInPage=cartSummaryPage.proceedToCheckout();
        CreateAccountPage createAccountPage= signInPage.createNewAccount();

       Addresses addresses = createAccountPage.registerNewUser(TestUtil.generateUserData());
        addresses.proceedToCheckout();
        ShippingPage shippingPage = new ShippingPage(driver);

        shippingPage.acceptTermsAndCheckout();




    }
}
