package com.company;

import com.compamy.pages.CategoryPage;
import com.compamy.pages.HomePage;
import com.compamy.pages.ItemPage;
import com.compamy.pages.LoginPage;
import com.compamy.utils.*;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;


public class LoginTestCase {
    private static final org.apache.log4j.Logger log = Logger.getLogger(LoginTestCase.class.getSimpleName());
    private static WebDriver driver;
    private static InputDataParser parser;
    private static HomePage homePage;
    private static CategoryPage categoryPage;
    private static ItemPage itemPage;
    private static LoginPage loginPage;

    @BeforeClass
    public static void initElements() throws IOException {
        driver = BrowserFactory.getBrowser(ListOfBrowsers.CHROME);
        driver.get(ConstantsList.HOMEPAGE_URL);
        homePage = PageFactory.initElements(driver,HomePage.class);
        categoryPage = PageFactory.initElements(driver,CategoryPage.class);
        itemPage = PageFactory.initElements(driver,ItemPage.class);
        loginPage = PageFactory.initElements(driver,LoginPage.class);
        parser = new InputDataParser(ConstantsList.PROPERTY_FILE);
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }

    @Test
    public void addItemToCardTest(){
        homePage.getLinkCategory().click();
        categoryPage.getLinkItem().click();
        itemPage.getLinkAddToCard().click();
        try {
            itemPage.getLinkProceedeToCheckout().click();
        } catch (ElementNotVisibleException e) {
            log.log(Priority.INFO, "Element invisible exception", e);
        }
        log.info("Button was found");
        Assert.assertEquals(parser.getSimpleProperty("expecteditemname"), driver.findElement(CssSelectors.CARD_TABLE_ITEMNAME_CELL).getText());

    }

    @Test
    public void loginTest(){
        homePage.getLinkLogin().click();
        loginPage.getEmailField().sendKeys(parser.getSimpleProperty("valid_login"));
        loginPage.getPasswordField().sendKeys(parser.getSimpleProperty("valid_password"));
        loginPage.getSignInButton().click();
        Assert.assertEquals(parser.getSimpleProperty("expectednickname"), driver.findElement(CssSelectors.LOGIN_USER_NAME).getText());
        loginPage.getLinkLogout().click();

    }

    @AfterClass
    public static void finishElements(){
        BrowserFactory.closeAllDrivers();
    }
}
