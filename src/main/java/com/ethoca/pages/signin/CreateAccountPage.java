package com.ethoca.pages.signin;

import com.ethoca.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.Map;

public class CreateAccountPage extends AbstractPage {
    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(id ="id_gender1" )
    private WebElement titleMrRadioBtn;

    @FindBy(id ="id_gender2" )
    private WebElement titleMrsRadioBtn;

    @FindBy(id = "customer_firstname")
    private WebElement firstName;

    @FindBy(id = "customer_lastname")
    private WebElement lastName;

    @FindBy(id = "passwd")
    private WebElement password;

    @FindBy(id="days")
    private WebElement dobDay;

    @FindBy(id="months")
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

    @FindBy(id = "postcode")
    private WebElement zip;

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


    private Select dobDayDropDwn = new Select(dobDay);
    private Select dobMonthDropDwn = new Select(dobMonth);
    private Select dobYearDropDwn = new Select(dobYear);
    private Select stateDrpDwn = new Select(state);
    private Select countryDrpDwn = new Select(country);


    public void registerNewUser(Map<String,String> userDetails){

        wait.until(ExpectedConditions.visibilityOf(registerBtn));
        if(userDetails.get("title").equals("Mr")){
            titleMrRadioBtn.click();
        }else if(userDetails.get("title").equals("Mrs")){
            titleMrsRadioBtn.click();
        }

        firstName.sendKeys(userDetails.get("firstName"));
        lastName.sendKeys(userDetails.get("lastName"));
        password.sendKeys(userDetails.get("password"));

        selectDob(userDetails.get("dob"));

        addressFirstName.sendKeys(userDetails.get("firstName"));
        addressLastName.sendKeys(userDetails.get("lastName"));
        addressLine1.sendKeys(userDetails.get("addressLine1"));
        addressLine2.sendKeys(userDetails.get("addressLine2"));
        city.sendKeys(userDetails.get("city"));
//        stateDrpDwn.selectByValue(userDetails.get("state"));
        stateDrpDwn.selectByValue("43");
        zip.sendKeys(userDetails.get("zip"));

        additionalInfo.sendKeys(userDetails.get("additionalInfo"));

        home.sendKeys(userDetails.get("homePhone"));
        mobile.sendKeys(userDetails.get("mobilePhone"));
        registerBtn.click();





    }


    private void selectDob(String dob){

        String[] date=dob.split("/");


        dobDayDropDwn.selectByValue(date[0]);

        dobMonthDropDwn.selectByIndex(2);

        dobYearDropDwn.selectByValue(date[2]);
    }

}
