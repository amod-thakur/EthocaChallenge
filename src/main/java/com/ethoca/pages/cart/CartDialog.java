package com.ethoca.pages.cart;

import com.ethoca.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartDialog extends AbstractPage {
	

	public CartDialog(WebDriver driver){
		super(driver);
	}
	
	@FindBy(linkText ="Proceed to checkout")
	private WebElement proceedToCheckOutBtn;

	@FindBy(linkText ="Continue shopping")
	private WebElement continueShoppingBtn;



	public void proceedToCheckout(){
//		driver.switchTo().activeElement();
		System.out.println(driver.getWindowHandle());
		driver.switchTo().defaultContent();
		System.out.println(driver.getWindowHandle());
		proceedToCheckOutBtn.click();
	}

	public void continueShopping(){
		continueShoppingBtn.click();
	}

}
