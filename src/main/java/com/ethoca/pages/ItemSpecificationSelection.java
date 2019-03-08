package com.ethoca.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ItemSpecificationSelection extends AbstractPage{


    public ItemSpecificationSelection(WebDriver driver){
        super(driver);
    }

    @FindBy(id = "group_1")
    WebElement size;

    @FindBy(id = "quantity_wanted")
    WebElement quantityBox;

    @FindBy( className = "icon-minus")
    WebElement reduceQuantityByOne;

    @FindBy( className = "icon-plus")
    WebElement increaseQuantityByOne;

    @FindBy(partialLinkText = "Add to cart")
    WebElement addToCartBtn;



    public void selectSize(String clothSize){
        Select sizeDropDown= new Select(size);
        sizeDropDown.selectByValue(clothSize);
    }
}
