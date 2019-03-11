package com.ethoca.tests;

import com.ethoca.pages.ItemQuickViewDialog;
import com.ethoca.pages.SummerDressesPage;
import com.ethoca.pages.WomenMegaMenu;
import com.ethoca.pages.cart.CartDialog;
import com.ethoca.pages.cart.CartSummaryPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class ItemQuickViewDialogTest extends BaseTest{

    ItemQuickViewDialog itemQuickViewDialog = null;
    @BeforeMethod
    public void setup(){
        WomenMegaMenu womenMegaMenu = landingPage.navigateToWomenMegaMenu();
        SummerDressesPage summerDressesPage =womenMegaMenu.selectSummerDresses();
        itemQuickViewDialog = summerDressesPage.quickViewDress();
    }

    @Test
    public void validateQuickViewDialogLoaaded(){
        Assert.assertTrue(itemQuickViewDialog.isQuickViewDialogDisplayed(),"The quick quick dialog is not displayed");

    }

    @Parameters({"size"})
    @Test
    public void validateUserIsAbleToAddItemToCart(String size){

        CartDialog cartDialog= itemQuickViewDialog.addItemToCart(size);
        Assert.assertTrue(cartDialog.isContinueShoppingPresent(),"The cart dialog modal is not displayed");

    }
}
