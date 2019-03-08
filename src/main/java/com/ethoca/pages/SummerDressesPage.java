package com.ethoca.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SummerDressesPage extends AbstractPage{


    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;

    public SummerDressesPage(WebDriver driver){
      super(driver);
    }

    @FindBy(xpath = "//a[@title = 'Printed Chiffon Dress' and @class='product_img_link']")
    WebElement printedChiffonDressImg;

}
