package com.ethoca.pages.signin;

import com.ethoca.pages.AbstractPage;
import org.openqa.selenium.WebDriver;

public class SignInPage extends AbstractPage {

    private CreateAccountSection createAccountSection = null;
    public SignInPage(WebDriver driver) {
        super(driver);
        createAccountSection= new CreateAccountSection(driver);
    }

    public CreateAccountPage createNewAccount(){
        return createAccountSection.createAccount();
    }


}
