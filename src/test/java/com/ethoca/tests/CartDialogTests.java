package com.ethoca.tests;

import com.ethoca.pages.ItemQuickViewDialog;
import com.ethoca.pages.SummerDressesPage;
import com.ethoca.pages.WomenMegaMenu;
import com.ethoca.pages.cart.CartDialog;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CartDialogTests extends BaseTest {

    CartDialog cartDialog;

    @BeforeMethod
    public void setup(){
        WomenMegaMenu womenMegaMenu = landingPage.navigateToWomenMegaMenu();
        SummerDressesPage summerDressesPage =womenMegaMenu.selectSummerDresses();
        ItemQuickViewDialog itemQuickViewDialog = summerDressesPage.quickViewDress();
        cartDialog = itemQuickViewDialog.addItemToCart("M");
    }


    @Test
    public void validateCartDialogIsDisplayed(){
        Assert.assertTrue(cartDialog.isContinueShoppingPresent(),"The Cart Dialog is not present");
    }

    @Test
    public void validateContinueShoppingFuncationality(){
        Assert.assertTrue(cartDialog.continueShopping().isWomenMegaMenuDisplayed(),"The Cart Dialog is not present");
    }

}
