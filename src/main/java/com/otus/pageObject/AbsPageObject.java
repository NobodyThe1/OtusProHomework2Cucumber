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

    protected GuiceScoped guiceScoped;
    protected Actions actions;
    protected Waiter waiter;
    protected WebDriver driver;

    @Inject
    public AbsPageObject (GuiceScoped guiceScoped) {
        this.guiceScoped = guiceScoped;
        this.driver = guiceScoped.driver;
        this.actions = new Actions(guiceScoped.driver);
        this.waiter = new Waiter(guiceScoped.driver);

        PageFactory.initElements(this.guiceScoped.driver,  this);
    }

    protected String courseTitleLocator = "//*[contains (text(), '%s')]";

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
