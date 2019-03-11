package com.ethoca.pages.cart;

import com.ethoca.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartSection extends AbstractPage {
    public CartSection(WebDriver driver) {
        super(driver);
    }

    @FindBy(id= "button_order_cart")
    WebElement checkoutBtn;

    @FindBy(className = "ajax_cart_block_remove_link")
    WebElement removeItemBtn;

    public CartSummaryPage checkout(){
        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.visibilityOf(checkoutBtn));
        checkoutBtn.click();
        return new CartSummaryPage(driver);
    }

    public Boolean isCheckoutBtnPresent(){
        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.visibilityOf(checkoutBtn));
        return  checkoutBtn.isDisplayed();
    }

}
