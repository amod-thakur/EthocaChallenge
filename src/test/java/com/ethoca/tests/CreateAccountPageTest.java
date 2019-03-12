package com.ethoca.tests;

import com.ethoca.pages.ItemQuickViewDialog;
import com.ethoca.pages.SummerDressesPage;
import com.ethoca.pages.WomenMegaMenu;
import com.ethoca.pages.cart.*;
import com.ethoca.pages.signin.CreateAccountPage;
import com.ethoca.utilities.Log;
import com.ethoca.utilities.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class CreateAccountPageTest extends BaseTest {
    CartSignInPage cartSignInPage;
    CreateAccountPage  createAccountPage=  null;
    private SoftAssert softAssert = new SoftAssert();
    @BeforeMethod
    public void setup(){
        WomenMegaMenu womenMegaMenu = landingPage.navigateToWomenMegaMenu();
        SummerDressesPage summerDressesPage =womenMegaMenu.selectSummerDresses();
        ItemQuickViewDialog itemQuickViewDialog = summerDressesPage.quickViewDress();
        CartDialog cartDialog = itemQuickViewDialog.addItemToCart("M");
        landingPage = cartDialog.continueShopping();
        CartSection cartSection = landingPage.viewCart();
        CartSummaryPage cartSummaryPage = cartSection.checkout();
         cartSignInPage =  cartSummaryPage.proceedToCheckout();
    }

    @Test
    public void validateCartSummaryPageIsLoaded(){
        Assert.assertTrue(cartSignInPage.isCreateAnAccountSectionPresent());
    }

    @Test
    public void validateProceedToCheckOutWorks(){
        createAccountPage = cartSignInPage.createNewAccount();
        Assert.assertTrue(createAccountPage.isCreateAccountTitlePresent());
    }

    @Test
    public void validateUserAccoutCreation(){
        createAccountPage = cartSignInPage.createNewAccount();
        CartAddressesPage cartAddressesPage = createAccountPage.registerNewUser(TestUtil.generateUserData());
        Assert.assertTrue(cartAddressesPage.isDeliverAddressTitlePresent());
    }

    @Test
    public void validateErrorIsDisplayedForCreateAccountWithoutData(){
        Log.info("Testing Account creation without any data");
        createAccountPage = cartSignInPage.createNewAccount();
        List<WebElement> errorDetails = createAccountPage.createAccountErrorAllBlank();
        softAssert.assertEquals(errorDetails.get(0).getText(),"There are 8 errors");
        softAssert.assertEquals(errorDetails.get(1).getText(),"You must register at least one phone number.");
        softAssert.assertEquals(errorDetails.get(2).getText(),"lastname is required.");
        softAssert.assertEquals(errorDetails.get(3).getText(),"firstname is required.");
        softAssert.assertEquals(errorDetails.get(4).getText(),"passwd is required.");
        softAssert.assertEquals(errorDetails.get(5).getText(),"address1 is required.");
        softAssert.assertEquals(errorDetails.get(6).getText(),"city is required.");
        softAssert.assertEquals(errorDetails.get(7).getText(),"The Zip/Postal code you've entered is invalid. It must follow this format: 00000");
        softAssert.assertEquals(errorDetails.get(8).getText(),"This country requires you to choose a State.");
        softAssert.assertAll();

    }

    @Test
    public void validateErrorIsDisplayedForCreateAccountWithInvalidData(){
        createAccountPage = cartSignInPage.createNewAccount();
        List<WebElement> errorDetails = createAccountPage.createAccountErrorInvalidValues();
        softAssert.assertEquals(errorDetails.get(0).getText(),"There are 4 errors");
        softAssert.assertEquals(errorDetails.get(1).getText(),"lastname is invalid.");
        softAssert.assertEquals(errorDetails.get(2).getText(),"firstname is invalid.");
        softAssert.assertEquals(errorDetails.get(3).getText(),"phone_mobile is invalid.");
        softAssert.assertEquals(errorDetails.get(4).getText(),"The Zip/Postal code you've entered is invalid. It must follow this format: 00000");
        softAssert.assertAll();

    }

}
