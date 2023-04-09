package com.otus.components;

import com.google.inject.Inject;
import com.otus.di.GuiceScoped;
import org.openqa.selenium.WebDriver;
import com.otus.pageObject.AbsPageObject;

public class AbsComponent<T> extends AbsPageObject<T> {

    @Inject
    public AbsComponent(GuiceScoped guiceScoped) {
        super(guiceScoped);
    }
}
