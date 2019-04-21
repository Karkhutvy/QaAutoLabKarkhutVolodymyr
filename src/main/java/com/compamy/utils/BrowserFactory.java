package com.compamy.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.HashMap;
import java.util.Map;

public class BrowserFactory {
    private static Map<ListOfBrowsers, WebDriver> drivers = new HashMap<>();


    public static WebDriver getBrowser(ListOfBrowsers browserName) {
        WebDriver driver = null;

        switch (browserName) {
            case FIREFOX:
                driver = drivers.get(ListOfBrowsers.FIREFOX);
                if (driver == null) {
                    driver = new FirefoxDriver();
                    drivers.put(ListOfBrowsers.FIREFOX, driver);
                }
                break;
            case IE:
                driver = drivers.get(ListOfBrowsers.IE);
                if (driver == null) {
                    System.setProperty("webdriver.ie.driver",
                            ".\\src\\main\\resources\\drivers\\IEDriverServer.exe");
                    driver = new InternetExplorerDriver();
                    drivers.put(ListOfBrowsers.IE, driver);
                }
                break;
            case CHROME:
                driver = drivers.get(ListOfBrowsers.CHROME);
                if (driver == null) {
                    System.setProperty("webdriver.chrome.driver",
                            ".\\src\\main\\resources\\drivers\\chromedriver.exe");
                    driver = new ChromeDriver();
                    drivers.put(ListOfBrowsers.CHROME, driver);
                }
                break;
        }
        return driver;
    }

    public static void closeAllDrivers() {
        for (ListOfBrowsers key : drivers.keySet()) {
            drivers.get(key).close();
            drivers.get(key).quit();
        }
    }
}


