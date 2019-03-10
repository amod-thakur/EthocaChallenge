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
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.HashMap;
import java.util.Map;

public class ValidateCartTest extends BaseTest {
    private LandingPage landingPgObj = null;
    private WomenMegaMenu womenMegaMenu = null;
    private SummerDressesPage summerDressesPage = null;
    private CartSummaryPage cartSummaryPage =null;
    private SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public void setup() {
        landingPgObj = openSite();
        womenMegaMenu =landingPgObj.navigateToWomenMegaMenu();
        summerDressesPage=  womenMegaMenu.selectSummerDresses();
        summerDressesPage.addDressToCart("M");
        landingPgObj = summerDressesPage.continueShopping();
        cartSummaryPage = landingPgObj.navigateToCheckoutPage();
    }

    @Test
    public void validateCartDetails(){

        PaymentsPage paymentsPage=cartSummaryPage.checkoutAsNewUser();
        Map<String,String> actualData =paymentsPage.readCartTable();
        softAssert.assertEquals(actualData.get("productImageURL"),"http://automationpractice.com/img/p/2/0/20-small_default.jpg","The image Text doesn't match");
        softAssert.assertEquals(actualData.get("productImageAlt"),"Printed Chiffon Dress","The image Text doesn't match");
        softAssert.assertEquals(actualData.get("productDescription"),"Printed Chiffon Dress SKU : demo_7 Color : Yellow, Size : M","The product description doesn't match");
        softAssert.assertEquals(actualData.get("availability"),"In stock","The availability doesn't match");
        softAssert.assertEquals(actualData.get("itemUnitPrice"),"$16.40","The item unit price doesn't match");
        softAssert.assertEquals(actualData.get("itemUnitDiscount")," -20% ","The item unit price doesn't match");
        softAssert.assertEquals(actualData.get("itemUnitOldPrice"),"$20.50","The item unit price doesn't match");
        softAssert.assertEquals(actualData.get("itemQty"),"1","The quantity doesn't match");
        softAssert.assertEquals(actualData.get("itemTotalPrice"),"$16.40","The quantity doesn't match");
        softAssert.assertEquals(actualData.get("totalProductPrice"),"$16.40","The quantity doesn't match");
        softAssert.assertEquals(actualData.get("totalShippingPrice"),"$2.00","The quantity doesn't match");
        softAssert.assertEquals(actualData.get("totalPrice"),"$18.40","The quantity doesn't match");
        softAssert.assertAll();




    }
}
