package com.compamy.pages;

import com.compamy.utils.BrowserFactory;
import com.compamy.utils.ListOfBrowsers;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ItemPage extends BasePage {
    @FindBy(css = "#add_to_cart > button")
    private WebElement linkAddToCard;
    @FindBy(css = "#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a")
    private WebElement linkProceedeToCheckout;

    public ItemPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getLinkAddToCard() {
        return linkAddToCard;
    }

    public WebElement getLinkProceedeToCheckout() {
        new WebDriverWait(BrowserFactory.getBrowser(ListOfBrowsers.CHROME),5)
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(ElementNotVisibleException.class)
                .until(ExpectedConditions.visibilityOf(this.linkProceedeToCheckout));
        return linkProceedeToCheckout;
    }
}
