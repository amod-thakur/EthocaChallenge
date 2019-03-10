package com.ethoca.pages.cart;

import Utilities.TestUtil;
import com.ethoca.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;
import java.util.Map;

public class PaymentsPage extends AbstractPage {
    public PaymentsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "cart_summary")
    private WebElement cartTable;

    @FindBy(xpath ="//td[@data-title= \"Total\"]" )
    private WebElement itemTotalPrice;

    @FindBy(xpath ="//span[contains(@id,'product_price')]/span[@class='price']" )
    private WebElement itemUnitPrice;

    @FindBy(xpath ="//span[contains(@id,'product_price')]/span[@class='price-percent-reduction small']" )
    private WebElement itemUnitDiscount;

    @FindBy(xpath ="//span[contains(@id,'product_price')]/span[@class='old-price']" )
    private WebElement itemUnitOldPrice;


    @FindBy(xpath ="//input[@class='cart_quantity_input form-control grey']" )
    private WebElement itemQty;

    @FindBy(id = "total_product")
    private WebElement totalProductPrice;

    @FindBy(id = "total_shipping")
    private WebElement totalShippingPrice;

    @FindBy(id = "total_price_without_tax")
    private WebElement totalPriceWithoutTax;

    @FindBy(id = "total_tax")
    private WebElement totalTax;

    @FindBy(id = "total_price")
    private WebElement totalPrice;


    @FindBy(className = "cart_avail")
    private WebElement availability;



    public void validateCartTable(String product,String Description,String availability,String unitPrice,String qty,String total,String totalProducts, String totalShipping,String finalTotal,String shippingAddress, String billingAddress){

//        Map<String, List<String>> productTable = TestUtil.readTable(cartTable);

    }
}
