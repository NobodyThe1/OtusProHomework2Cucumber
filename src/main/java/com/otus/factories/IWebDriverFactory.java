package com.otus.factories;

import com.otus.exceptions.BrowserNotSupportedException;
import org.openqa.selenium.WebDriver;


public interface IWebDriverFactory {
    WebDriver create(String browserName) throws BrowserNotSupportedException;
}

