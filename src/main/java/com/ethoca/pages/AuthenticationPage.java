package com.ethoca.pages;//package com.pomframework.pages;
//
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//
//import com.pomframework.base.TestBase;
//
//public class AuthenticationPage extends TestBase {
//	
//	//Initialising Page elements using Page Object Factory
//	@FindBy(id ="email")
//	WebElement emailId;
//	
//	@FindBy(id ="passwd")
//	WebElement password;
//	
//	@FindBy(id="SubmitLogin")
//	WebElement submitBtn;
//	
//	@FindBy(linkText = "Forgot your password?")
//	WebElement forgotPasswordLink;
//	
//	public AuthenticationPage(){
//		PageFactory.initElements(driver, this);
//	}
//	
//	//page actions or behaviours
//	
//	public void signInUser(String userName, String userPassword){
//		emailId.sendKeys(userName);
//		password.sendKeys(userPassword);
//		submitBtn.click();
//		
//	}
//	
//	public String checkPageTitle(){
//		return driver.getTitle();
//	}
//	
//
//}
