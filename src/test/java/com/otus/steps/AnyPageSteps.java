package com.otus.steps;

import com.google.inject.Inject;
import com.otus.pages.AnyPage;
import io.cucumber.java.ru.Тогда;

public class AnyPageSteps {

    @Inject
    private AnyPage anyPage;

    @Тогда("Откроется страница курса {string}")
    public void checkPage(String title) {
        anyPage.rightPageShouldBeOpened(title);
    }
}
