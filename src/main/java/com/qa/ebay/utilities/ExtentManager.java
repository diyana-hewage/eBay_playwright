package com.qa.ebay.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    private static ExtentReports extent;

    public static ExtentReports createInstance(String filePath) {
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(filePath);
        htmlReporter.config().setDocumentTitle("eBay Automation with Playwright ");
        htmlReporter.config().setReportName("Verify Test Cases ");

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Tester", "Diyana");
        extent.setSystemInfo("Environment", "QA");
        return extent;
    }

    public static ExtentReports getInstance() {
        return extent;
    }
}

