package com.ethoca.pages;

import com.ethoca.pages.cart.CartDialog;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class ItemQuickViewDialog extends AbstractPage{




    @FindBy(id = "group_1")
    private WebElement size;

    @FindBy(id = "quantity_wanted")
    private WebElement quantityBox;

    @FindBy( className = "icon-minus")
    private WebElement reduceQuantityByOne;

    @FindBy( className = "icon-plus")
    private WebElement increaseQuantityByOne;

    @FindBy(id = "add_to_cart")
    private WebElement addToCartBtn;

    @FindBy(className="fancybox-outer")
    private WebElement productQuickView;

    @FindBy(xpath="//iframe[contains(@id,'fancybox-frame')]")
    private WebElement productQuickViewiFrame;

    @FindBy(className = "box-info-product")
    private WebElement productSpecSelectionSection;

    @FindBy(id="wishlist_button")
    private WebElement wishList;

    public ItemQuickViewDialog(WebDriver driver) {
        super(driver);
    }


    public CartDialog addItemToCart(String clothSize){

        switchToQuickView();
        wait.until(ExpectedConditions.visibilityOf(addToCartBtn));
        selectSize(clothSize);
        addToCartBtn.click();
        return new CartDialog(driver);
    }

    private void selectSize(String clothSize){
        Select sizeDropDown= new Select(size);
        sizeDropDown.selectByVisibleText(clothSize);
    }

    public Boolean isQuickViewDialogDisplayed(){
        switchToQuickView();
        return addToCartBtn.isDisplayed();

    }



    private void switchToQuickView(){
        wait.until(ExpectedConditions.visibilityOf(productQuickView));
        driver.switchTo().frame(productQuickViewiFrame);
    }
}
