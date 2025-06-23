package com.qa.ebay.pages;

import com.microsoft.playwright.Page;

public class HomePage {
    private Page page;



    //locators
    private String search ="input[title='Search']";
    private String searchbutton="button[id='gh-search-btn']";
    private String searchPageHeader= "div[class='srp-controls__row-cells'] span:nth-child(2)";

    private String mainProduct="li[id='item3daf6f1d88'] div[class='s-item__image-wrapper image-treatment']";


    //Page constructor

    public HomePage(Page page){
        this.page=page;
    }


    //methods/actions

    public String getHomePageTitle(){
        String pagetitle=page.title();
        System.out.println("Page title is "+ pagetitle);
        return pagetitle;

    }
    public String getHomePAgeUrl(){
        String url=page.url();
        System.out.println("Url is "+ url);
        return url;
    }
    public String doSearch(String productName){
        page.fill(search,productName);
        page.click(searchbutton);
        String header= page.textContent(searchPageHeader);
        System.out.println("Header of the page "+ header);
        return header;
    }
    public ProductPage selectMainProduct(){
        page.click(mainProduct);
        return new ProductPage(page);

    }

}


