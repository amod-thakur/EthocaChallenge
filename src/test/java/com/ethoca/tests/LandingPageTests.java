package com.ethoca.tests;



import com.ethoca.pages.SummerDressesPage;
import com.ethoca.pages.WomenMegaMenu;
import org.testng.Assert;
import org.testng.annotations.Test;




public class LandingPageTests extends BaseTest{


	@Test(description = "Validate successful navigation to Summer Dresses page")
	public void validateNavigationToSummerDressesPg(){

		WomenMegaMenu womenMegaMenu =landingPage.navigateToWomenMegaMenu();
		SummerDressesPage summerDressesPage =womenMegaMenu.selectSummerDresses();
		Assert.assertNotNull(summerDressesPage);
	}
	
}


