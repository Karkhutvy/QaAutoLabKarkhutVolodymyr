package com.compamy.pages;

import com.compamy.utils.ConstantsList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasePage {
    private WebDriver driver;

    BasePage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(partialLinkText = "Sign")
    private WebElement linkLogin;

    @FindBy(name = "search_query")
    private WebElement linkCategory;

    @FindBy(css = "#header > div.nav > div > div > nav > div:nth-child(2) > a")
    private WebElement linkLogout;

    public WebElement getLinkLogin() {
        return linkLogin;
    }

    public WebElement getLinkCategory() {
        return linkCategory;
    }

    public WebElement getLinkLogout() {
        return linkLogout;
    }
}
