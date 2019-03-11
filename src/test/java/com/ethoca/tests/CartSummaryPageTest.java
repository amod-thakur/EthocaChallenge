package com.ethoca.tests;

import com.ethoca.pages.ItemQuickViewDialog;
import com.ethoca.pages.SummerDressesPage;
import com.ethoca.pages.WomenMegaMenu;
import com.ethoca.pages.cart.CartDialog;
import com.ethoca.pages.cart.CartSection;
import com.ethoca.pages.cart.CartSignInPage;
import com.ethoca.pages.cart.CartSummaryPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartSummaryPageTest extends BaseTest {

    CartSummaryPage cartSummaryPage = null;
    @BeforeMethod
    public void setup(){
        WomenMegaMenu womenMegaMenu = landingPage.navigateToWomenMegaMenu();
        SummerDressesPage summerDressesPage =womenMegaMenu.selectSummerDresses();
        ItemQuickViewDialog itemQuickViewDialog = summerDressesPage.quickViewDress();
        CartDialog cartDialog = itemQuickViewDialog.addItemToCart("M");
        landingPage = cartDialog.continueShopping();
        CartSection cartSection = landingPage.viewCart();
        cartSummaryPage = cartSection.checkout();
    }

    @Test
    public void validateCartSummaryPageIsLoaded(){
        Assert.assertTrue(cartSummaryPage.isSummaryPgTitlePresent());
    }

    @Test
    public void validateProceedToCheckOutWorks(){
        CartSignInPage cartSignInPage = cartSummaryPage.proceedToCheckout();
        Assert.assertTrue(cartSignInPage.isCreateAnAccountSectionPresent());
    }

}
