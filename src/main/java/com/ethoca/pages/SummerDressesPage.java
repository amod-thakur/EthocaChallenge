package com.ethoca.pages;

import com.ethoca.pages.cart.CartDialog;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SummerDressesPage extends AbstractPage{





    public SummerDressesPage(WebDriver driver){
      super(driver);
    }

    @FindBy(xpath = "//a[@title = 'Printed Chiffon Dress' and @class='product_img_link']")
    WebElement printedChiffonDressImg;

    public CartDialog addDressToCart(String size){
        wait.until(ExpectedConditions.visibilityOf(printedChiffonDressImg));
        printedChiffonDressImg.click();
        ItemSpecificationSelection itemSpecificationSelection= new ItemSpecificationSelection(driver);
        return itemSpecificationSelection.addItemToCart(size);
    }

    public LandingPage continueShopping(){
        CartDialog cartDialog = new CartDialog(driver);
        cartDialog.continueShopping();
        return new LandingPage((driver));
    }

}
