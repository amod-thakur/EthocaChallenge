package com.ethoca.tests;

import com.ethoca.pages.ItemQuickViewDialog;
import com.ethoca.pages.SummerDressesPage;
import com.ethoca.pages.WomenMegaMenu;
import com.ethoca.pages.cart.CartDialog;
import com.ethoca.pages.cart.CartSection;
import com.ethoca.pages.cart.CartSummaryPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartSectionTest extends BaseTest {

    CartSection cartSection;
    @BeforeMethod
    public void setup(){

            WomenMegaMenu womenMegaMenu = landingPage.navigateToWomenMegaMenu();
            SummerDressesPage summerDressesPage =womenMegaMenu.selectSummerDresses();
            ItemQuickViewDialog itemQuickViewDialog = summerDressesPage.quickViewDress();
            CartDialog cartDialog = itemQuickViewDialog.addItemToCart("M");
            landingPage = cartDialog.continueShopping();
            cartSection = landingPage.viewCart();
    }

    @Test
    public void validateCartSectionExpandsOnHover(){
        Assert.assertTrue(cartSection.isCheckoutBtnPresent());
    }

    @Test
    public void validateCartSummaryPageIsLoadedOnCheckout(){
        CartSummaryPage cartSummaryPage = cartSection.checkout();
                Assert.assertTrue(cartSummaryPage.isSummaryPgTitlePresent());

    }
}
