package com.ethoca.tests;



import org.testng.annotations.Test;
import com.ethoca.pages.cart.CartDialog;
import com.ethoca.pages.LandingPage;


public class LandingPageTests extends BaseTest{


	@Test(description = "Validate successful navigation to  Authentication page")
	public void validateNavigationToAuthentiationPg(){

		landingPage.clickOnSignInLink();

	}
	
	@Test(description = "Validate successful navigation to  Shirts page")
	public void validateNavigationToTShirtPg(){
		landingPage.navigateToTShirtsPg();
	}
	
	@Test(description = "Validate add to cart functionality")
	public void validateAddItemToCart(){
		CartDialog cartDialogObj =landingPage.addItemToCart();
		cartDialogObj.proceedToCheckout();

	}
		
	}


