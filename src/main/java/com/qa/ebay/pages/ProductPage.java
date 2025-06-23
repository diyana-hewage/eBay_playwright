package com.qa.ebay.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.ArrayList;
import java.util.List;

public class ProductPage {
    private  Page page;

    //Locators in product page



    private String productTitle = "//div[@class='vim x-item-title']";
    private String productPrice = "div[class='x-price-primary'] span[class='ux-textspans']";
    private String sellerdetails = ".ux-chevron";
    private String addtocart = "#atcBtn_btn_1";
    private String addtowatchlist = "#watchBtn_btn_1";
    private String shippingdetails = "div[class='ux-labels-values col-12 ux-labels-values--shipping'] div[class='ux-labels-values__labels col-3'] div[class='ux-labels-values__labels-content'] div span[class='ux-textspans']";
    private String deliverydetails = "div[class='ux-labels-values col-12 ux-labels-values__column-last-row ux-labels-values--deliverto'] div[class='ux-labels-values__labels col-3'] div[class='ux-labels-values__labels-content'] div span[class='ux-textspans']";
    private String returndetails = "div[class='ux-labels-values col-12 ux-labels-values__column-last-row ux-labels-values--returns'] div[class='ux-labels-values__labels col-3'] div[class='ux-labels-values__labels-content'] div span[class='ux-textspans']";
    private String paymentmethod = "div[class='ux-labels-values col-12 ux-labels-values__column-last-row ux-labels-values--payments'] div[class='ux-labels-values__labels col-3'] div[class='ux-labels-values__labels-content'] div span[class='ux-textspans']";
    private String bestSelleritemTitle = "//h2[normalize-space()='Similar items']";
    private String seemoreText = "//div[contains(@class,'zwH9 EGf- MuPu')]//span[contains(@role,'text')][normalize-space()='See all']";
    private String relatedProducts = "//div[@class='hVQz Cssx']//img";
    private String priceRange = "//div[@class='hVQz Cssx']//span[contains(text(),'$')]";


//page constructor
    public ProductPage(Page page){
        this.page=page;

    }

    //page actions/methods
public  boolean verifyProductdetails(){
        return page.isVisible(productPrice) &&
                page.isVisible(sellerdetails) &&
                page.isVisible(addtocart) &&
                page.isVisible(addtowatchlist) &&
                page.isVisible(shippingdetails) &&
                page.isVisible(deliverydetails) &&
                page.isVisible(returndetails) &&
                page.isVisible(paymentmethod);
    }


    public boolean verifyseeMoreText() {
        return page.isVisible(seemoreText);

    }

    public int verifyRelatedProduct() {
        return page.locator(relatedProducts).count();
    }
    public boolean verifySelleritemTitle(){
        return page.isVisible(bestSelleritemTitle);
    }



    public double getMainProductPrice() {
        String priceText = page.locator(productPrice).first().textContent().replaceAll("[^0-9.]", "");
        return Double.parseDouble(priceText);
    }


    public List<Double> getRelatedProductPrices() {
        List<Double> prices = new ArrayList<>();
        Locator priceElements = page.getByAltText("$");

        for (int i = 0; i < priceElements.count(); i++) {
            String text = priceElements.nth(i).textContent().replaceAll("[^0-9.]", "");
            if (!text.isEmpty()) {
                prices.add(Double.parseDouble(text));
            }
        }
        return prices;
    }
}











