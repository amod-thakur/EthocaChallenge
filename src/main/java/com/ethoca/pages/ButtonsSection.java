package com.ethoca.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ButtonsSection extends AbstractPage{


    public ButtonsSection(WebDriver driver) {
        super(driver);
    }

    @FindBy(partialLinkText = "Proceed to checkout")
    private WebElement proceedToCheckOutBtn;

    @FindBy(partialLinkText = "Continue shopping")
    private WebElement continueShopping;

    public void proceedToCheckOut(){
        proceedToCheckOutBtn.click();
    }

    public void continueShopping(){
        continueShopping.click();
    }
}
