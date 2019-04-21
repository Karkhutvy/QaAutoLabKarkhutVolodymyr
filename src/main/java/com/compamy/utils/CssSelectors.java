package com.compamy.utils;

import org.openqa.selenium.By;

public interface CssSelectors {
    By  LOGIN_BUTTON_LINK = By.partialLinkText("Sign");
    By LOGOUT_BUTTON_LINK = By.cssSelector("#header > div.nav > div > div > nav > div:nth-child(2) > a");
    By CATEGORY_MENU_ITEM_LINK = By.name("search_query");
    By CARD_TABLE_ITEMNAME_CELL = By.cssSelector("td.cart_description > p > a");
    By CATEGORY_ITEM_LINK = By.cssSelector("a[title=\"Faded Short Sleeve T-shirts\"]");
    By EMAIL_LOGIN_FIELD = By.id("email");
    By PASSWORD_LOGIN_FIELD = By.id("passwd");
    By SUBMIT_LOGIN_BUTTON = By.id("SubmitLogin");
    By ADD_TO_CARD_BUTTON = By.cssSelector("#add_to_cart > button");
    By PROCEED_TO_CHECKOUT_BUTTON = By.cssSelector("#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a");
    By LOGIN_USER_NAME = By.cssSelector("#header > div.nav > div > div > nav > div:nth-child(1) > a > span");


}
