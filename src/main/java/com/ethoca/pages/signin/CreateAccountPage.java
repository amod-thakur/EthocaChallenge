package com.ethoca.pages.signin;

import com.ethoca.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPage extends AbstractPage {
    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "customer_firstname")
    private WebElement firstName;

    @FindBy(id = "customer_lastname")
    private WebElement lastName;

    @FindBy(id = "passwd")
    private WebElement password;

    @FindBy(id="days")
    private WebElement dobDay;

    @FindBy(id="days")
    private WebElement dobMonth;

    @FindBy(id="years")
    private WebElement dobYear;

    @FindBy(id ="firstname")
    private WebElement addressFirstName;

    @FindBy(id ="lastname")
    private WebElement addressLastName;

    @FindBy(id = "address1")
    private WebElement addressLine1;

    @FindBy(id = "address2")
    private WebElement addressLine2;

    @FindBy(id = "city")
    private WebElement city;

    @FindBy (id = "id_state")
    private WebElement state;

    @FindBy (id = "id_country")
    private WebElement country;

    @FindBy (id = "other")
    private WebElement additionalInfo;

    @FindBy (id = "phone_mobile")
    private WebElement home;

    @FindBy (id = "phone_mobile")
    private WebElement mobile;

    @FindBy (id = "alias")
    private WebElement addressAlias;

    @FindBy(id = "submitAccount")
    private WebElement registerBtn;


}
