package com.otus.pages;

import com.google.inject.Inject;
import com.otus.annotations.Path;
import com.otus.di.GuiceScoped;
import org.openqa.selenium.WebDriver;
import com.otus.pageObject.AbsPageObject;

public abstract class AbsPage<T> extends AbsPageObject<T> {

    private String baseUrl = System.getProperty("base.url", "https://otus.ru");

    @Inject
    public AbsPage (GuiceScoped guiceScoped) {
        super(guiceScoped);
    }

    private String getPath() {
        Path path = getClass().getAnnotation(Path.class);
        if(path != null) {
            return path.value();
        }
        return "";
    }
    public void open() {
        guiceScoped.driver.get(baseUrl + getPath());
    }
}
