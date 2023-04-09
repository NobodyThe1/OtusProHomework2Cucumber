package com.otus.steps;

import com.google.inject.Inject;
import com.otus.pages.MainPage;
import io.cucumber.java.ru.Пусть;

public class MainPageSteps {

    @Inject
    private MainPage mainPage;

    @Пусть("Открыта главная страница")
    public void openPage() {
        mainPage.open();
    }
}