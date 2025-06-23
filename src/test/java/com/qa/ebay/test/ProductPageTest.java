package com.qa.ebay.test;

import com.qa.ebay.appconstant.ApplicationConstant;
import com.qa.ebay.base.BaseTest;
import com.qa.ebay.pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ProductPageTest extends BaseTest{



    @Test
    public void productDetailsTest() {
        Assert.assertTrue(productPage.verifyProductdetails(), "Product details are not visible ");

    }

    @Test
    public void sellerItemTitle(){
        Assert.assertTrue(productPage.verifySelleritemTitle(),"Seller item Title is not available");
    }

    @Test
    public void seeMoreText(){
        Assert.assertTrue(productPage.verifyseeMoreText(),"See more Text  is not available");

    }

    @Test
    public void relatedProducts(){
        int count = productPage.verifyRelatedProduct();
        Assert.assertTrue(count <= 6, "More than 6 products displayed");
    }

    @Test
    public void relatedproductPrice() {
        double mainPrice = productPage.getMainProductPrice();
        List<Double> prices = productPage.getRelatedProductPrices();

        for (double price : prices) {
            double min = mainPrice * (1 - ApplicationConstant.PRICE_RANGE_PERCENT);
            double max = mainPrice * (1 + ApplicationConstant.PRICE_RANGE_PERCENT);
            Assert.assertTrue(price >= min && price <= max,
                    "Price out of expected range: " + price);
        }



    }
}









