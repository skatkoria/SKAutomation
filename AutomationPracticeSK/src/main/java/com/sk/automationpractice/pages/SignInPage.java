package com.sk.automationpractice.pages;

import com.sk.automationpractice.utils.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {

    WebDriver driver;

    @FindBy(id = "email")
    private WebElement username;

    @FindBy(id = "passwd")
    private WebElement password;

    @FindBy(css = "#SubmitLogin > span")
    private WebElement submitButton;

    @FindBy(css = ".account > span")
    private WebElement accountName;


    public SignInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String login(String username, String password) {
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        submitButton.click();
        Log.info("Signed in user is: " + accountName.getText());
        System.out.println("Signed in user is: " + accountName.getText());
        return accountName.getText();

    }

}
