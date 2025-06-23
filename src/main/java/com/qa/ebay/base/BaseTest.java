package com.qa.ebay.base;

import com.microsoft.playwright.Page;
import com.qa.ebay.pages.HomePage;
import com.qa.ebay.pages.ProductPage;
import com.qa.ebay.utilities.PlaywrightFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    PlaywrightFactory pf;
    Page page;
    protected Properties properties;
    protected HomePage homePage;
    protected ProductPage productPage;

    @BeforeTest
    public void setup() throws IOException {
        pf=new PlaywrightFactory();
        properties=pf.init_prop();
        page=pf.initBrowser(properties);
        homePage=new HomePage(page);
        productPage=new ProductPage(page);
    }
    @AfterTest
    public void tearDown(){
        page.context().browser().close();
    }
}


