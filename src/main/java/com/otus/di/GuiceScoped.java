package com.otus.di;

import com.otus.factories.WebDriverFactory;
import io.cucumber.guice.ScenarioScoped;
import org.openqa.selenium.WebDriver;

@ScenarioScoped
public class GuiceScoped {
    public WebDriver driver = new WebDriverFactory().create(new WebDriverFactory().getBrowserName());
}
