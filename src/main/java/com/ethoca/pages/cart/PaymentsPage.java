package com.ethoca.pages.cart;

import Utilities.TestUtil;
import com.ethoca.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PaymentsPage extends AbstractPage {
    public PaymentsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "cart_summary")
    private WebElement cartTable;

    @FindBy(xpath = "//td/a/img")
    private WebElement productImg;

    @FindBy(xpath ="//td[@data-title= \"Total\"]" )
    private WebElement itemTotalPrice;

    @FindBy(xpath ="//td/span[@class='price']/span[contains(@class,'special')]" )
    private WebElement itemUnitPrice;

    @FindBy(xpath ="//span[contains(@id,'product_price')]/span[@class='price-percent-reduction small']" )
    private WebElement itemUnitDiscount;

    @FindBy(xpath ="//span[contains(@id,'product_price')]/span[@class='old-price']" )
    private WebElement itemUnitOldPrice;


    @FindBy(xpath ="//td[@class='cart_quantity text-center']" )
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

    @FindBy(className = "product-name")
    private WebElement productDescription;

//String product,String Description,String availability,String unitPrice,String qty,String total,String totalProducts, String totalShipping,String finalTotal,String shippingAddress, String billingAddress){

    public void readCartTable(){

        Map<String,String> cartValues = new HashMap<String, String>();

        cartValues.put("productImage", productImg.getAttribute("alt"));
        cartValues.put("productDescription", productDescription.getText());
        cartValues.put("availability", availability.getText());
        cartValues.put("itemUnitPrice", itemUnitPrice.getText());
        cartValues.put("itemUnitDiscount", itemUnitDiscount.getText());
        cartValues.put("itemUnitOldPrice", itemUnitOldPrice.getText());
        cartValues.put("itemQty", itemQty.getText());
        cartValues.put("itemTotalPrice", itemTotalPrice.getText());
        cartValues.put("totalProductPrice", totalProductPrice.getText());
        cartValues.put("totalShippingPrice", totalShippingPrice.getText());
        cartValues.put("totalPrice", totalPrice.getText());

        System.out.println(cartValues);







    }
}
