package com.ethoca.tests;



import org.testng.annotations.Test;
import com.ethoca.pages.cart.CartDialog;
import com.ethoca.pages.LandingPage;


public class LandingPageTests extends BaseTest{

	LandingPage landingPgObj;
	
	@Test(description = "Validate successful navigation to  Authentication page")
	public void validateNavigationToAuthentiationPg(){
		
		landingPgObj = openSite();
		landingPgObj.clickOnSignInLink();

	}
	
	@Test(description = "Validate successful navigation to  Shirts page")
//	@Description("This test cases validates if the user is able to successfully navigate to Shirts page")
	
	public void validateNavigationToTShirtPg(){
		 landingPgObj = openSite();
		landingPgObj.navigateToTShirtsPg();
	}
	
	@Test(description = "Validate add to cart functionality")
//	@Description("This test cases validates if the user is able to successfully add an item to cart")
	public void validateAddItemToCart(){
		 landingPgObj = openSite();
		CartDialog cartDialogObj =landingPgObj.addItemToCart();
		cartDialogObj.proceedToCheckout();

//		System.out.println(TestUtil.readTable(driver.findElement(By.id("cart_summary")).findElement(By.xpath("//tfoot"))));
	}
		
	}


