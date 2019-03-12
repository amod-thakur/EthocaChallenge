package com.ethoca.tests;

import com.ethoca.pages.ItemQuickViewDialog;
import com.ethoca.pages.SummerDressesPage;
import com.ethoca.pages.WomenMegaMenu;
import com.ethoca.pages.cart.*;
import com.ethoca.pages.signin.CreateAccountPage;
import com.ethoca.utilities.TestUtil;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CartAddressPageTest extends BaseTest {

    CartAddressesPage cartAddressesPage;
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
        cartAddressesPage =createAccountPage.registerNewUser(TestUtil.generateUserData());
    }

    @Test(enabled = false)
    public void validateAddressPageIsLoaded(){
        Assert.assertTrue(cartAddressesPage.isDeliverAddressTitlePresent());
    }

    @Test
    public void validateProceedToCheckout(){
        CartShippingPage cartShippingPage = cartAddressesPage.proceedToCheckout();
        Assert.assertTrue(cartShippingPage.isShippingTitlePresent());
    }


}
