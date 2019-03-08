package com.ethoca.tests;//package com.pomframework.tests;
//
//import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//import com.pomframework.base.TestBase;
//import com.pomframework.pages.AuthenticationPage;
//import com.pomframework.pages.LandingPage;
//
//public class AuthenticationPageTest extends TestBase{
//	LandingPage landingPgObj;
//	AuthenticationPage authPgObj;
//	String userId= properties.getProperty("username");
//	String password = properties.getProperty("password");
//	
//	public AuthenticationPageTest(){
//		//initialise the config values
//		super();
//	}
//	
//	@BeforeMethod
//	public void setup(){
//		initialise();
//		
//		landingPgObj = new LandingPage();
//		
//		authPgObj = landingPgObj.clickOnSignInLink();
//		
//	}
//	
//	
//	@Test
//	public void validateAuthPgTitle(){
//		String actualTitle = authPgObj.checkPageTitle();
//		String expectedTitle = "Login - My Store";
//		
//		Assert.assertEquals(actualTitle, expectedTitle);
//	}
//	@Test
//	public void validateLogin(){
//		authPgObj.signInUser(userId, password);
//	}
//	
//	
//	
//	@AfterMethod
//	public void tearDown(){
//		driver.quit();
//		
//	}
//
//}
