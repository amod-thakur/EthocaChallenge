package com.ethoca.pages.cart;

import com.ethoca.pages.AbstractPage;
import com.ethoca.pages.signin.CreateAccountPage;
import com.ethoca.pages.signin.CreateAccountSection;
import org.openqa.selenium.WebDriver;

public class CartSignInPage extends AbstractPage {

    private CreateAccountSection createAccountSection = null;
    public CartSignInPage(WebDriver driver) {
        super(driver);
        createAccountSection= new CreateAccountSection(driver);
    }

    public CreateAccountPage createNewAccount(){
        return createAccountSection.createAccount();
    }


}
