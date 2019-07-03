package com.sk.automationpractice.pages;

import com.sk.automationpractice.utils.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TopMenuBar {


    WebDriver driver;
    @FindBy(xpath = "//*[@id='block_top_menu']//li[1]//li[1]//li[1]/a")
    WebElement tshirts;
    @FindBy(xpath = "//*[@id='block_top_menu']//li[1]/a")
    private WebElement womenLink;

    public TopMenuBar(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public ViewProductsPage womenTopsLink() {
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.visibilityOf(womenLink));
        wait1.until(ExpectedConditions.elementToBeClickable(womenLink));

        Actions action = new Actions(driver);
        action.moveToElement(womenLink).build().perform();
        System.out.println("Moved to womenlink");
        wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='block_top_menu']//li[1]//li[1]//li[1]/a")));
        wait1.until(ExpectedConditions.visibilityOf(tshirts));
        wait1.until(ExpectedConditions.elementToBeClickable(tshirts));

        System.out.println("Waited for tshirts");
        tshirts.click();
        Log.info("Clicked on Tshirts");

        return new ViewProductsPage(driver);

    }


}
