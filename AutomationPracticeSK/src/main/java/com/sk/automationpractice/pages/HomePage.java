package com.sk.automationpractice.pages;

import com.sk.automationpractice.utils.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {


    WebDriver driver;

    @FindBy(className = "login")
    private WebElement signInLink;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String login(String username, String password) {
        Log.debug("Signing with credentials: " + username + "  and  " + password);
        signInLink.click();
        SignInPage signInPage = new SignInPage(driver);
        return signInPage.login(username, password);
    }


}
