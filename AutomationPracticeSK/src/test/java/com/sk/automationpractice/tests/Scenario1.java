package com.sk.automationpractice.tests;

import com.sk.automationpractice.pages.HomePage;
import com.sk.automationpractice.pages.TopMenuBar;
import com.sk.automationpractice.pages.ViewProductsPage;
import com.sk.automationpractice.utils.Log;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Scenario1 extends TestBase {

    @BeforeMethod
    public void navigateToURL() {
        getUrl(CONFIG.getProperty("url"));
    }


    @Test
    public void productBuy() {
        Log.startTestCase("login");

        HomePage homePage = new HomePage(driver);
        String accountName = homePage.login(CONFIG.getProperty("username"), CONFIG.getProperty("password"));
        Assert.assertEquals(accountName, CONFIG.getProperty("customer_account_name"));

        TopMenuBar menuBar = new TopMenuBar(driver);
        ViewProductsPage productsPage = menuBar.womenTopsLink();
        productsPage.addItemToCart();

        Assert.assertEquals(productsPage.getSuccessMessageAddCart(), CONFIG.getProperty("successMessageAddCart"));
        Assert.assertEquals(productsPage.getProductName(), CONFIG.getProperty("productName"));
        Assert.assertEquals(productsPage.getProductQuantity(), CONFIG.getProperty("productQuantity"));
        Assert.assertTrue(productsPage.getProductColor().contains(CONFIG.getProperty("productColor")));
        Assert.assertEquals(productsPage.getTotalBilling(), CONFIG.getProperty("totalBilling"));

    }
}



