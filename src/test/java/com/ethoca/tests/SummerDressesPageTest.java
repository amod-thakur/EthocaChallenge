package com.ethoca.tests;

import com.ethoca.pages.ItemQuickViewDialog;
import com.ethoca.pages.LandingPage;
import com.ethoca.pages.SummerDressesPage;
import com.ethoca.pages.WomenMegaMenu;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SummerDressesPageTest extends BaseTest {

    private WomenMegaMenu womenMegaMenu = null;
    private SummerDressesPage summerDressesPage = null;

    @BeforeMethod
    public void setup(){
        womenMegaMenu =landingPage.navigateToWomenMegaMenu();
        summerDressesPage= womenMegaMenu.selectSummerDresses();
    }

    @Test(description = "validate the page title is 'Summer Dresses - My Store' ")
    public void validatePageTitle(){
        String title =summerDressesPage.getPageTitle();
        Assert.assertEquals(title,"Summer Dresses - My Store", "The title doesn't match the expected value");
    }

    @Test(description = "validate 'Printed Chiffon Dress' is present on the page")
    public void validatePrintedChiffonDressIsPresent(){
        Boolean dressPresent=summerDressesPage.getPrintedChiffonDressImg().isDisplayed();
        Assert.assertTrue(dressPresent,"The Printed Chiffon Dress is not present");
    }

    @Test(description = "validate Quick View funtionality")
    public void validateQuickViewFuncationality(){
        ItemQuickViewDialog itemQuickViewDialog=summerDressesPage.quickViewDress();
    }
}
