package com.ethoca.utilities;

import com.ethoca.pages.AbstractPage;
import com.ethoca.pages.WomenMegaMenu;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Utility class .It contains reusable static methods
 * @author Amod Thaur
 *
 */


public class TestUtil extends AbstractPage {


    /**
     * @param driver
     */
    public TestUtil(WebDriver driver) {
        super(driver);
    }





    /**
     * This method is used to hover over an Element on the page
     * @param element
     * @param driver
     */
    public static void hoverOverElement(WebElement element,WebDriver driver){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }


    /**
     * This method is used to generate random email id ending in @test.com
     * @return generated emailAddress
     */
    public static String generateEmail(){

        return RandomStringUtils.randomAlphabetic(6) + "@test.com";
    }

    /**
     * This method is used to generate a random 6 character name
     * @return
     */
    public static String generateName(){
        return RandomStringUtils.randomAlphabetic(6);
    }

    /**
     * This method is used to generate a random 10 character password.
     * @return
     */
    public static String generatePassword(){
        return  RandomStringUtils.randomAlphanumeric(10);
    }


    /**
     * This method is used to generate a random 10 character  numeric string.
     * @return
     */

    public static String generateNumericData(){
        return  RandomStringUtils.randomNumeric(10);
    }

    /**
     * This method is used to generate a random 10 character alpha numeric string.
     * @return
     */

    public static String generateAlphaNumericData(){
        return  RandomStringUtils.randomAlphanumeric(10);
    }

    /**
     * This method is used to generate the user details required for creating an account
     * @return - a Map containing the user data
     */
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

    /**
     * This method is used to read the data from xls file and send it as a map to the DataProvider class
     * @param fileName the file which contains the test data
     * @return a map of object, object containing the test data
     */
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


    /**
     * This method is used to select a drop down option using its partial display text
     * @param select - the element identifier for the drop down
     * @param partialText - partial text for selection
     */
    public static void selectOptionByPartText(WebElement select, String partialText) {
        Select s = new Select(select);
        s.getOptions()
                .parallelStream()
                .filter(option -> option.getText().toLowerCase()
                        .contains(partialText.toLowerCase()))
                .findFirst()
                .ifPresent(option -> s.selectByValue(option.getAttribute("value")));
    }


    public static void takeScreenshotAtEndOfTest(WebDriver driver) throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String currentDir = System.getProperty("user.dir");
        FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
    }


    public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException{

        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        // after execution, you could see a folder "FailedTestsScreenshots"
        // under src folder
        String destination = System.getProperty("user.dir") + "test-output/FailedTestsScreenshots/" + screenshotName +  "_Failed.png";
        File finalDestination = new File(destination);
        FileUtils.copyFile(source, finalDestination);
        return destination;
    }

}

