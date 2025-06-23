package com.qa.ebay.utilities;

import com.microsoft.playwright.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PlaywrightFactory {
    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;
    Page page;
    Properties properties;


    //initialize the factory
    public Page initBrowser(Properties properties){

        String browserName=properties.getProperty("browser");
        System.out.println("Browser name is "+ browserName);
        playwright=Playwright.create();



        //cross browser testing
        switch (browserName.toLowerCase()){
            case "chromium":
                browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "firefox":
                browser= playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "safari":
                browser=playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "chrome":
                browser= playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
                break;
            default:
                System.out.println("Please pass the correct browser name ");
                break;

        }

        browserContext=browser.newContext();
        page=browserContext.newPage();
        page.navigate(properties.getProperty("application_url").trim());
        return page;

    }

    public Properties init_prop() throws IOException {

        FileInputStream input=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");

        properties=new Properties();
        properties.load(input);
        return properties;
    }
}


