package com.otus.steps;

import com.otus.di.GuiceScoped;

import com.google.inject.Inject;
import com.otus.factories.WebDriverFactory;
import io.cucumber.java.ru.Пусть;

public class CommonSteps {

    @Inject
    private GuiceScoped guiceScoped;

    @Пусть("Открываем браузер {string}")
    public void openBrowser(String browserName) {
        guiceScoped.driver = new WebDriverFactory().create(browserName);
    }
}
