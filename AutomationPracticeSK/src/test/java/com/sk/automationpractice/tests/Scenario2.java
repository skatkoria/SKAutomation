package com.sk.automationpractice.tests;

import com.sk.automationpractice.pages.GooglePage;
import com.sk.automationpractice.pages.SearchResultPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Scenario2 extends TestBase {


    @BeforeMethod
    public void navigateToURL() {
        getUrl(CONFIG.getProperty("url2"));
    }


    @Test
    public void searchName() {
        GooglePage googlePage = new GooglePage(driver);
        SearchResultPage searchResultPage = googlePage.search(CONFIG.getProperty("name"));
        Assert.assertEquals(searchResultPage.getTitle(), CONFIG.getProperty("pagetitle"));


    }

}
