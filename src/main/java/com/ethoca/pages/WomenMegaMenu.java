package com.ethoca.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WomenMegaMenu extends AbstractPage{
    public WomenMegaMenu(WebDriver driver) {
        super(driver);
    }

    @FindBy(partialLinkText = "Summer Dresses")
    private WebElement summerDresses;

    public SummerDressesPage selectSummerDresses(){
        wait.until(ExpectedConditions.visibilityOf(summerDresses));
        summerDresses.click();
        return new SummerDressesPage(driver);
    }
}
