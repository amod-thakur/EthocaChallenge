package com.ethoca.tests;

import Utilities.TestUtil;
import com.ethoca.pages.HeaderSection;
import com.ethoca.pages.LandingPage;
import com.ethoca.pages.SummerDressesPage;
import com.ethoca.pages.WomenMegaMenu;
import com.ethoca.pages.cart.CartDialog;
import com.ethoca.pages.cart.CartSection;
import com.ethoca.pages.cart.CartSummaryPage;
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

        Map<String,String> userDetails = new HashMap<String ,String>();
        userDetails.put("title","Mr");
        userDetails.put("firstName", TestUtil.generateName());
        userDetails.put("lastName", TestUtil.generateName());
        userDetails.put("password", TestUtil.generatePassword());
        userDetails.put("dob", "20/February /1998");
        userDetails.put("addressLine1", "1810 N Greenville Ave");
        userDetails.put("addressLine2", "1234");
        userDetails.put("city", "Richardson");
        userDetails.put("state", "Texas");
        userDetails.put("additionalInfo", "additionalInfo");
        userDetails.put("homePhone", "12321323213");
        userDetails.put("mobilePhone", "12321323213");
        userDetails.put("zip","75081");


        createAccountPage.registerNewUser(userDetails);



    }
}
