package com.qa.ebay.test;

import com.qa.ebay.appconstant.ApplicationConstant;
import com.qa.ebay.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @Test
    public void gethomepageTitleTest(){
        String actualtitle=homePage.getHomePageTitle();

        Assert.assertEquals(actualtitle, ApplicationConstant.SEARCH_PAGE_TITIL,"not in the right page ");
    }

    @Test
    public void homepageUrlTest(){
        String actualurl=homePage.getHomePAgeUrl();
        Assert.assertEquals(actualurl,properties.getProperty("application_url"));
    }

    @Test
    public void searchTest(){
        String actualheader=homePage.doSearch("Wallet");
        Assert.assertEquals(actualheader,"Wallet");


    }
}


