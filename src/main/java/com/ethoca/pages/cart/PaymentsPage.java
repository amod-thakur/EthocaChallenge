package com.ethoca.pages.cart;

import com.ethoca.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
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

    @FindBy(xpath = "//p[@class='product-name']/a")
    private WebElement productName;

    @FindBy(xpath = "//td[@class='cart_description']/small/a")
    private WebElement productSpecs;

    @FindBy(className = "cart_ref")
    private WebElement sku;


    public Map<String, String> readCartTable(){

        Map<String,String> cartValues = new HashMap<String, String>();
        String productDescription = productName.getText() + " " + sku.getText() + " " +productSpecs.getText();

        cartValues.put("productImageAlt", productImg.getAttribute("alt"));
        cartValues.put("productImageURL", productImg.getAttribute("src"));
        cartValues.put("productDescription", productDescription);
        cartValues.put("availability", availability.getText());
        cartValues.put("itemUnitPrice", itemUnitPrice.getText());
        cartValues.put("itemUnitDiscount", itemUnitDiscount.getText());
        cartValues.put("itemUnitOldPrice", itemUnitOldPrice.getText());
        cartValues.put("itemQty", itemQty.getText());
        cartValues.put("itemTotalPrice", itemTotalPrice.getText());
        cartValues.put("totalProductPrice", totalProductPrice.getText());
        cartValues.put("totalShippingPrice", totalShippingPrice.getText());
        cartValues.put("totalPrice", totalPrice.getText());

       return cartValues;







    }
}
