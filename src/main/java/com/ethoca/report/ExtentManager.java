package com.ethoca.report;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
    private static ExtentReports extent;

    private ExtentManager(){

    }

    public static synchronized  ExtentReports getReporter(){
        if(extent == null){
            //Set HTML reporting file location
            String workingDir = System.getProperty("user.dir");
            extent = new ExtentReports(workingDir+"\\ExtentReports\\ExtentReportResults.html", true);
        }
        return extent;
    }
}
