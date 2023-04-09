package com.otus.hooks;

import com.otus.di.GuiceScoped;
import io.cucumber.java.After;
import com.google.inject.Inject;

public class Hooks {

    @Inject
    private GuiceScoped guiceScoped;

    @After
    public void close() {
        if (guiceScoped.driver != null) {
            guiceScoped.driver.close();
            guiceScoped.driver.quit();
        }
    }
}
