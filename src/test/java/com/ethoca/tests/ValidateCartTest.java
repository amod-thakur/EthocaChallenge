package com.ethoca.tests;

import com.ethoca.utilities.TestUtil;
import com.ethoca.pages.LandingPage;
import com.ethoca.pages.SummerDressesPage;
import com.ethoca.pages.WomenMegaMenu;
import com.ethoca.pages.cart.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.log4testng.Logger;

import java.util.Map;

/**
 * This class tests the Cart functionality
 * @author  Amod Thakur
 *
 */
public class ValidateCartTest extends BaseTest {
    private WomenMegaMenu womenMegaMenu = null;
    private SummerDressesPage summerDressesPage = null;
    private CartSummaryPage cartSummaryPage =null;
    private SoftAssert softAssert = new SoftAssert();

    final static Logger log = Logger.getLogger(ValidateCartTest.class);

    @BeforeMethod
    public void setup() {
        womenMegaMenu =landingPage.navigateToWomenMegaMenu();
        summerDressesPage=  womenMegaMenu.selectSummerDresses();
        summerDressesPage.addDressToCart("M");
        landingPage = summerDressesPage.continueShopping();
        cartSummaryPage = landingPage.navigateToCheckoutPage();
    }


      @Test(dataProvider = "ProductDetails", description = "Validate Cart contents with the test xls")
    public void validateAllCartDetails(Map<Object,Object> expectedData){


        log.info("The expected data is : "+expectedData);

        CartPaymentsPage cartPaymentsPage =cartSummaryPage.checkoutAsNewUser();

        Map<String,String> actualData = cartPaymentsPage.readCartTable();

        log.info("The actual data is : "+actualData);

        softAssert.assertEquals(actualData.get("productImageURL"),expectedData.get("productImageURL"),"The image URL doesn't match with the expected value");

        softAssert.assertEquals(actualData.get("productImageAlt"),expectedData.get("productImage"),"The image Text doesn't match");

        softAssert.assertEquals(actualData.get("productDescription"),expectedData.get("productDescription"),"The product description doesn't match");

        softAssert.assertEquals(actualData.get("availability"),expectedData.get("availability"),"The availability doesn't match");

        softAssert.assertEquals(actualData.get("itemUnitPrice"),expectedData.get("itemUnitPrice"),"The item unit price doesn't match");

        softAssert.assertEquals(actualData.get("itemUnitDiscount"),expectedData.get("itemUnitDiscount"),"The discount doesn't match with the expected value");

        softAssert.assertEquals(actualData.get("itemUnitOldPrice"),expectedData.get("itemUnitOldPrice"),"The old price doesn't match with the expected value");

        softAssert.assertEquals(actualData.get("itemQty"),expectedData.get("itemQty"),"The item quantity doesn't match with the expected value");

        softAssert.assertEquals(actualData.get("itemTotalPrice"),expectedData.get("itemTotalPrice"),"The item total price doesn't match with the expected value");

        softAssert.assertEquals(actualData.get("totalProductPrice"),expectedData.get("totalProductPrice"),"The total product price doesn't match with the expected value");

        softAssert.assertEquals(actualData.get("totalShippingPrice"),expectedData.get("totalShippingPrice"),"The total shipping price doesn't match with the expected value");

        softAssert.assertEquals(actualData.get("totalPrice"),expectedData.get("totalPrice"),"The total price doesn't match with the expected value");

        softAssert.assertAll();
    }


    /**
     * Data provider for the test method
     * @return
     */
    @DataProvider(name = "ProductDetails")
    public Object[][] getData(){

        return TestUtil.readXlsData("ProductDetails.xlsx");

    }
}
