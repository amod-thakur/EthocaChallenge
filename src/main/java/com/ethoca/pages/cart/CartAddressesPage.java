package com.ethoca.pages.cart;

import com.ethoca.pages.AbstractPage;
import com.ethoca.pages.ButtonsSection;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartAddressesPage extends AbstractPage {
    public CartAddressesPage(WebDriver driver) {
        super(driver);
        buttonsSection= new ButtonsSection(driver);
    }

    ButtonsSection buttonsSection = null;

    @FindBy (xpath = "//button/span[contains(text(),'Proceed')]")
    private WebElement proceedToCheckoutBtn;

    @FindBy(xpath = "//h3[contains(text(),'Your delivery address')]")
    private WebElement deliverAddressTitle;

    public CartShippingPage proceedToCheckout(){
        wait.until(ExpectedConditions.visibilityOf(proceedToCheckoutBtn));
        proceedToCheckoutBtn.click();
        return new CartShippingPage(driver);
    }

    public Boolean isDeliverAddressTitlePresent(){
        return deliverAddressTitle.isDisplayed();
    }
}
