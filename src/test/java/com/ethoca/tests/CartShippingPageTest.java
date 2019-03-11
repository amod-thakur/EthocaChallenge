package com.ethoca.tests;

import com.ethoca.pages.ItemQuickViewDialog;
import com.ethoca.pages.SummerDressesPage;
import com.ethoca.pages.WomenMegaMenu;
import com.ethoca.pages.cart.*;
import com.ethoca.pages.signin.CreateAccountPage;
import com.ethoca.utilities.TestUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CartShippingPageTest extends BaseTest {
    CartShippingPage cartShippingPage;

    SoftAssert softAssert = new SoftAssert();
    @BeforeMethod
    public void setup(){
        WomenMegaMenu womenMegaMenu = landingPage.navigateToWomenMegaMenu();
        SummerDressesPage summerDressesPage =womenMegaMenu.selectSummerDresses();
        ItemQuickViewDialog itemQuickViewDialog = summerDressesPage.quickViewDress();
        CartDialog cartDialog = itemQuickViewDialog.addItemToCart("M");
        landingPage = cartDialog.continueShopping();
        CartSection cartSection = landingPage.viewCart();
        CartSummaryPage cartSummaryPage = cartSection.checkout();
        CartSignInPage cartSignInPage =  cartSummaryPage.proceedToCheckout();
        CreateAccountPage createAccountPage=cartSignInPage.createNewAccount();
        CartAddressesPage cartAddressesPage =createAccountPage.registerNewUser(TestUtil.generateUserData());
        cartShippingPage = cartAddressesPage.proceedToCheckout();
    }

    @Test
     public  void validateShippingPageIsLoaded(){
        Assert.assertTrue(cartShippingPage.isShippingTitlePresent());
    }

    @Test
    public void validateAcceptTermsAndCheckout(){
        CartPaymentsPage cartPaymentsPage= cartShippingPage.acceptTermsAndCheckout();
        Assert.assertTrue(cartPaymentsPage.isPaymentTitlePresent());
    }

    @Test
    public void validateTermsErrorModalIsDisplayed(){

        TermsErrorModal termsErrorModal =cartShippingPage.proceedUncheckedTermsError();
        softAssert.assertTrue(termsErrorModal.isTermsErrorPresent());
        softAssert.assertEquals(termsErrorModal.getTermsError(),"You must agree to the terms of service before continuing.");
        softAssert.assertAll();
    }

    @Test
    public void validateCloseTermsErrorModal(){

        TermsErrorModal termsErrorModal =cartShippingPage.proceedUncheckedTermsError();
        cartShippingPage =termsErrorModal.closeTermsError();
        Assert.assertTrue(cartShippingPage.isShippingTitlePresent());

    }
}
