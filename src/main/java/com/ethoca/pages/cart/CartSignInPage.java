package com.ethoca.pages.cart;

import com.ethoca.pages.AbstractPage;
import com.ethoca.pages.signin.CreateAccountPage;
import com.ethoca.pages.signin.CreateAccountSection;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartSignInPage extends AbstractPage {

    private CreateAccountSection createAccountSection = null;
    public CartSignInPage(WebDriver driver) {
        super(driver);
        createAccountSection= new CreateAccountSection(driver);
    }

    @FindBy(xpath = "//h3[contains(text(),'Create an account')]")
    private WebElement creatAnAccountSectionTitle;

    public CreateAccountPage createNewAccount(){
        return createAccountSection.createAccount();
    }

    public Boolean isCreateAnAccountSectionPresent(){
        return creatAnAccountSectionTitle.isDisplayed();
    }


}
