package com.otus.pages;

import com.google.inject.Inject;
import com.otus.annotations.Path;
import com.otus.di.GuiceScoped;
import org.openqa.selenium.WebDriver;

@Path("/")
public class MainPage extends AbsPage<MainPage> {

    @Inject
    public MainPage (GuiceScoped guiceScoped) {
        super(guiceScoped);
    }
}
