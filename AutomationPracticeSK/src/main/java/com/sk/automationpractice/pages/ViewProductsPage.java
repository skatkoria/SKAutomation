package com.sk.automationpractice.pages;

import com.sk.automationpractice.utils.Log;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ViewProductsPage {


    WebDriver driver;

    @FindBy(xpath = "//*[@id='center_column']//div[2]//h5/a")
    private WebElement prod1;

    @FindBy(xpath = "//*[@id='center_column']//div[2]/div[2]/a[1]/span")
    private WebElement prod1AddToCart;


    @FindBy(xpath = "//*[@id='layer_cart']/div[1]/div[1]/h2")
    private WebElement successMessageAddCart;

    @FindBy(id = "layer_cart_product_title")
    private WebElement productName;

    @FindBy(id = "layer_cart_product_quantity")
    private WebElement productQuantity;

    @FindBy(id = "layer_cart_product_attributes")
    private WebElement productColor;

    @FindBy(xpath = "//*[@id='layer_cart']//div[3]/span")
    private WebElement totalBilling;


    public ViewProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addItemToCart() {

        Actions actions = new Actions(driver);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", prod1);
        actions.moveToElement(prod1).build().perform();

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.visibilityOf(prod1AddToCart));

        prod1AddToCart.click();
        Log.info(prod1.getText() + " is added to cart");

    }

    public String getSuccessMessageAddCart() {
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.visibilityOf(successMessageAddCart));

        String str = successMessageAddCart.getText();
        System.out.println(str);
        return str;
    }

    public String getProductName() {
        return productName.getText();

    }

    public String getProductQuantity() {
        return productQuantity.getText();

    }

    public String getProductColor() {
        return productColor.getText();

    }

    public String getTotalBilling() {
        return totalBilling.getText();

    }


}
