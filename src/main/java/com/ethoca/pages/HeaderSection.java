package com.ethoca.pages;

import com.ethoca.pages.cart.CartSection;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderSection extends AbstractPage{


    public HeaderSection(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "ajax_cart_product_txt_s")
    private WebElement cartMenu;


    public CartSection openCartMenu(){
        actions.moveToElement(cartMenu).build().perform();
        return new CartSection(driver);
    }
}
