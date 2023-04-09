package com.otus.factories;

import com.opera.core.systems.OperaDriver;
import com.otus.exceptions.BrowserNotSupportedException;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.Locale;


public class WebDriverFactory implements IWebDriverFactory {

    private String browserName = System.getProperty("browser", "chrome").toLowerCase(Locale.ROOT);
    public String getBrowserName() {
        return browserName;
    }

    public EventFiringWebDriver create(String browserName) {
        switch (browserName) {
            case "chrome": {
                WebDriverManager.chromedriver().setup();
                return new EventFiringWebDriver(new ChromeDriver());
            }
            case "firefox": {
                WebDriverManager.firefoxdriver().setup();
                return new EventFiringWebDriver(new FirefoxDriver());
            }
            case "opera": {
                WebDriverManager.operadriver().setup();
                return new EventFiringWebDriver(new OperaDriver());
            }
            default:
                try {
                    throw new BrowserNotSupportedException(browserName);
                } catch (BrowserNotSupportedException ex) {
                    ex.printStackTrace();
                    return null;
                }
        }
    }
}