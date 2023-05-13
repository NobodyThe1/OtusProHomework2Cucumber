package com.otus.pageObject;

import com.google.inject.Inject;
import com.otus.di.GuiceScoped;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.otus.waiters.Waiter;

public abstract class AbsPageObject<T> {

    protected Actions actions;

    @Inject
    public GuiceScoped guiceScoped;

    @Inject
    public Waiter waiter;

    @Inject
    public AbsPageObject (GuiceScoped guiceScoped) {
        this.guiceScoped = guiceScoped;
        this.actions = new Actions(guiceScoped.driver);
        PageFactory.initElements(this.guiceScoped.driver, this);
    }

    protected String courseTitleLocator = "//*[contains(@class, 'lessons__new-item-title')][contains (text(), 's')]";

    protected void moveAndClick (WebElement element) {
        waiter.waitForCondition(ExpectedConditions.visibilityOf(element));
        actions.moveToElement(element);
        actions.click();
    }

    protected void moveAndPerform (WebElement element) {
        waiter.waitForCondition(ExpectedConditions.visibilityOf(element));
        actions.moveToElement(element);
        actions.click()
                .build()
                .perform();
    }
}
