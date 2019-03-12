package com.ethoca.pages.cart;

import com.ethoca.pages.AbstractPage;
import com.ethoca.pages.LandingPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartDialog extends AbstractPage {
	

	public CartDialog(WebDriver driver){
		super(driver);
	}
	
	@FindBy(linkText ="Proceed to checkout")
	private WebElement proceedToCheckOutBtn;

	@FindBy(xpath ="//span[@title ='Continue shopping']")
	private WebElement continueShoppingBtn;



	public CartSummaryPage proceedToCheckout(){

		driver.switchTo().defaultContent();
		wait.until(ExpectedConditions.visibilityOf(proceedToCheckOutBtn));
		proceedToCheckOutBtn.click();
		return new CartSummaryPage(driver);
	}

	public LandingPage continueShopping(){

		wait.until(ExpectedConditions.visibilityOf(continueShoppingBtn));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", continueShoppingBtn);
//		continueShoppingBtn.click();
		return new LandingPage(driver);
	}

	public Boolean isProceedToCheckoutPresent(){

		return  proceedToCheckOutBtn.isDisplayed();
	}

	public Boolean isContinueShoppingPresent(){

		return  proceedToCheckOutBtn.isDisplayed();
	}

}
