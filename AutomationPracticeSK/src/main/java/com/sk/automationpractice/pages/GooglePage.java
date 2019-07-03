package com.sk.automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePage {

    WebDriver driver;

    @FindBy(name = "q")
    private WebElement searchArea;
    ;


    @FindBy(xpath = "(//a/h3)[2]")
    private WebElement thirdResult;

    public GooglePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public SearchResultPage search(String name) {
        searchArea.sendKeys(name);
        searchArea.submit();
        thirdResult.click();
        return new SearchResultPage(driver);
    }


}
