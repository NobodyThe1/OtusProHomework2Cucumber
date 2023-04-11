package com.otus.pages;

import com.google.inject.Inject;
import com.otus.di.GuiceScoped;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AnyPage extends AbsPage<AnyPage>{

    @Inject
    public AnyPage(GuiceScoped guiceScoped) {
        super(guiceScoped);
    }

    public void rightPageShouldBeOpened(String title) {
        Assertions.assertEquals((guiceScoped.driver.findElement(By.xpath(String.format(courseTitleLocator, title))).getText()), title);
    }
}
