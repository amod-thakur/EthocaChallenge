package com.ethoca.pages;

import com.ethoca.pages.cart.CartDialog;
import com.ethoca.pages.cart.CartSection;
import com.ethoca.pages.cart.CartSummaryPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


/**
 * Landing page of the application.Contains element locators and actions for the Landing page
 * @author Amod Thakur
 */
public class LandingPage  extends AbstractPage{
	
	

	//Page Elements using Page Factory
	
	@FindBy(className = "login")
	private WebElement signInLink;
	
	@FindBy(xpath = "//a[@title='Women']")
	private WebElement womenLink;
	
	@FindBy(xpath = "//a[@title='Dresses']")
	private WebElement dressesLink;
	
	@FindBy(xpath = "//a[@title='T-shirts']")
	public WebElement tShirtLink;
	
	@FindBy(xpath = "//a[@title='Blouses']")
	private WebElement blousesLink;
	
	@FindBy(xpath = "//a[@title='Casual Dresses']")
	private WebElement casualDressesLink;
	
	@FindBy(xpath = "//a[@title='Evening Dresses']")
	private WebElement eveningDressesLink;
	
	@FindBy(xpath = "//a[@title='Summer Dresses']")
	private WebElement summerDressesLink;
	
	@FindBy(xpath = "//a[@title='Faded Short Sleeve T-shirts']")
	private WebElement productName;
	
	@FindBy(xpath="//a[@title= 'Add to cart']")
	private WebElement addToCartBtn;

	private  HeaderSection headerSection;

	//Intialising the page object factory
	public LandingPage(WebDriver driver){
		super(driver);
		headerSection=new HeaderSection(driver);
	}
	
	//page actions or behaviours

	public void navigateToTShirtsPg(){
		actions.moveToElement(womenLink).build().perform();
		tShirtLink.click();

		
	}

	public void navigateToBlousesPg(){
		actions.moveToElement(womenLink).perform();
		blousesLink.click();
		
	}
	
	public CartDialog addItemToCart(){

		actions.moveToElement(productName).perform();
		addToCartBtn.click();
		return new CartDialog(this.driver);
	}

	public void clickOnSignInLink(){
		
		signInLink.click();
		

	}

	public WomenMegaMenu navigateToWomenMegaMenu(){
		headerSection.openWomenMegaMenu();
		return new WomenMegaMenu(driver);
	}

	public CartSection viewCart(){
		headerSection.openCartMenu();
		return new CartSection(driver);
	}

	public CartSummaryPage navigateToCheckoutPage(){

		CartSection cartSection = headerSection.openCartMenu();
		cartSection.checkout();
		return new CartSummaryPage(driver);
	}
	

}
