package Utilities;

import com.ethoca.pages.AbstractPage;
import com.ethoca.pages.WomenMegaMenu;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestUtil extends AbstractPage {



    public TestUtil(WebDriver driver) {
        super(driver);
    }

    public static Map<String, List<String>> readTable(WebElement table){

        Map<String, List<String>> objTable = new HashMap<String, List<String>>();
//        String tableXpath ="//div[@id='detailInfoDiv']//tr";
        List<WebElement> objRows = table.findElements(By.xpath("//tr"));
        for(int iCount=0; iCount<objRows.size(); iCount++){
            List<WebElement> objCol = objRows.get(iCount).findElements(By.tagName("td"));
            List<String> columns = new ArrayList<String>();
            for(int col=0; col<objCol.size(); col++){
                columns.add(objCol.get(col).getText());
            }
            objTable.put(String.valueOf(iCount), columns);
        }

        return objTable;
    }


    public static void hoverOverElement(WebElement element,WebDriver driver){
       Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }
//    public static Map<String, List<String>> readTable(String tableName,WebDriver driver){
//
//        Map<String, List<String>> objTable = new HashMap<String, List<String>>();
//        String tableXpath ="//div[@id='detailInfoDiv']//tr";
//        List<WebElement> objRows = driver.findElements(By.xpath(tableXpath));
//        for(int iCount=0; iCount<objRows.size(); iCount++){
//            List<WebElement> objCol = objRows.get(iCount).findElements(By.tagName("td"));
//            List<String> columns = new ArrayList<String>();
//            for(int col=0; col<objCol.size(); col++){
//                columns.add(objCol.get(col).getText());
//            }
//            objTable.put(String.valueOf(iCount), columns);
//        }
//
//        return objTable;
//    }



    public static String generateEmail(){

        return RandomStringUtils.randomAlphabetic(6) + "@test.com";
    }

    public static String generateName(){
        return RandomStringUtils.randomAlphabetic(6);
    }
    public static String generatePassword(){
        return  RandomStringUtils.randomAlphanumeric(10);
    }
}
