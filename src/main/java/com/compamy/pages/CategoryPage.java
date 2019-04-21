package com.compamy.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CategoryPage extends BasePage {
   @FindBy(css = "a[title=\"Faded Short Sleeve T-shirts\"]")
   private WebElement linkItem;

    public CategoryPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getLinkItem() {
        return linkItem;
    }
}
