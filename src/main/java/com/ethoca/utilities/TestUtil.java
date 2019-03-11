package com.ethoca.utilities;

import com.ethoca.pages.AbstractPage;
import com.ethoca.pages.WomenMegaMenu;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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



    public static List<String> readHeading(WebElement table){

        List<String> tableHeaders = new ArrayList<String>();
        List<WebElement> headerText = table.findElements(By.xpath("//thead/tr/th"));
        for(WebElement heading : headerText){
            tableHeaders.add(heading.getText());
            System.out.println(heading.getText());


        }

        return  tableHeaders;
    }

    public static List<List<String>> readTableBody(WebElement table){

        List<List<String>> tableData = new ArrayList<List<String>>();
        List<WebElement> tableRows = table.findElements(By.xpath("//tbody//tr[contains(@id,'product')]"));


        for(WebElement row : tableRows){
            List<WebElement> tableColumns = row.findElements(By.xpath("//td"));
            List<String> rowData = new ArrayList<String>();
            for(WebElement column : tableColumns ){
                rowData.add(column.getText());
            }
            tableData.add(rowData);
        }

        return tableData;



    }

    public static void hoverOverElement(WebElement element,WebDriver driver){
       Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }




    public static String generateEmail(){

        return RandomStringUtils.randomAlphabetic(6) + "@test.com";
    }

    public static String generateName(){
        return RandomStringUtils.randomAlphabetic(6);
    }
    public static String generatePassword(){
        return  RandomStringUtils.randomAlphanumeric(10);
    }

    public static Map<String,String> generateUserData(){
        Map<String,String> userDetails = new HashMap<String ,String>();
        userDetails.put("title","Mr");
        userDetails.put("firstName", generateName());
        userDetails.put("lastName", generateName());
        userDetails.put("password", generatePassword());
        userDetails.put("dob", "20/February /1998");
        userDetails.put("addressLine1", "1810 N Greenville Ave");
        userDetails.put("addressLine2", "1234");
        userDetails.put("city", "Richardson");
        userDetails.put("state", "Texas");
        userDetails.put("additionalInfo", "additionalInfo");
        userDetails.put("homePhone", "12321323213");
        userDetails.put("mobilePhone", "12321323213");
        userDetails.put("zip","75081");

        return userDetails;



    }

    public static Object[][] readXlsData(String fileName)  {

            File file = new File(System.getProperty("user.dir")+"/src/main/resources/testData/"+fileName);
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        XSSFWorkbook wb = null;
        try {
            wb = new XSSFWorkbook(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        XSSFSheet sheet = wb.getSheetAt(0);

        try {
            wb.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int lastRowNum = sheet.getLastRowNum() ;
            int lastCellNum = sheet.getRow(0).getLastCellNum();
            Object[][] obj = new Object[lastRowNum][1];

            for (int i = 0; i < lastRowNum; i++) {
                Map<Object, Object> datamap = new HashMap<Object, Object>();
                for (int j = 0; j < lastCellNum; j++) {
                    datamap.put(sheet.getRow(0).getCell(j).toString(), sheet.getRow(i+1).getCell(j).toString());
                }
                obj[i][0] = datamap;

            }
            return  obj;
        }




    public static void selectOptionByPartText(WebElement select, String partialText) {
        Select s = new Select(select);
        s.getOptions()
                .parallelStream()
                .filter(option -> option.getText().toLowerCase()
                        .contains(partialText.toLowerCase()))
                .findFirst()
                .ifPresent(option -> s.selectByValue(option.getAttribute("value")));
    }

}

