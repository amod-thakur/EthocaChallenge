package com.ethoca.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    public AbstractPage(WebDriver driver){
        this.driver=driver;
        this.wait= new WebDriverWait(this.driver,30);
        this.actions = new Actions(this.driver);
        PageFactory.initElements(this.driver,this);
    }


}
