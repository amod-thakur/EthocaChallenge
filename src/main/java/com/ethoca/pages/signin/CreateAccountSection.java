package com.ethoca.pages.signin;

import com.ethoca.utilities.TestUtil;
import com.ethoca.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountSection extends AbstractPage {
    public CreateAccountSection(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "email_create")
    private WebElement emailAddressField;

    @FindBy(id ="SubmitCreate")
    private WebElement createAnAccountBtn;

    public CreateAccountPage createAccount(){

        emailAddressField.sendKeys(TestUtil.generateEmail());
        createAnAccountBtn.click();
        return new CreateAccountPage(driver);
    }
}
