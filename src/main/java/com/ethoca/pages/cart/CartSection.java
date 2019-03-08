package com.ethoca.pages.cart;

import com.ethoca.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartSection extends AbstractPage {
    public CartSection(WebDriver driver) {
        super(driver);
    }

    @FindBy(id= "button_order_cart")
    WebElement checkoutBtn;

    @FindBy(className = "ajax_cart_block_remove_link")
    WebElement removeItemBtn;

    public CartSummaryPage checkout(){
    checkoutBtn.click();
    return new CartSummaryPage(driver);
    }

}
