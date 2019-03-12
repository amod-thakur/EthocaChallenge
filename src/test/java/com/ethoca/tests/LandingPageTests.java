package com.ethoca.tests;



import com.ethoca.pages.SummerDressesPage;
import com.ethoca.pages.WomenMegaMenu;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.ethoca.pages.cart.CartDialog;



public class LandingPageTests extends BaseTest{


	@Test(description = "Validate successful navigation to  Authentication page")
	public void validateNavigationToAuthentiationPg(){

		landingPage.clickOnSignInLink();

	}
	
	@Test(description = "Validate successful navigation to  Summer Dresses page")
	public void validateNavigationToTShirtPg(){

		WomenMegaMenu womenMegaMenu =landingPage.navigateToWomenMegaMenu();
		SummerDressesPage summerDressesPage =womenMegaMenu.selectSummerDresses();
		Assert.assertNotNull(summerDressesPage);
	}
	
	@Test(description = "Validate add to cart functionality")
	public void validateAddItemToCart(){
		CartDialog cartDialogObj =landingPage.addItemToCart();
		cartDialogObj.proceedToCheckout();

	}
		
	}


