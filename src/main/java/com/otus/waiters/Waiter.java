
package com.otus.waiters;

import com.google.inject.Inject;
import com.otus.di.GuiceScoped;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;


import java.time.Duration;
public class Waiter {

    @Inject
    private GuiceScoped guiceScoped;

    @Inject
    public Waiter(GuiceScoped guiceScoped) {
        this.guiceScoped = guiceScoped;
    }

    public boolean waitForCondition (ExpectedCondition condition) {
        WebDriverWait webDriverWait = new WebDriverWait(guiceScoped.driver, 10);
        try {
            webDriverWait.until(condition); {
                return true;
            }
        } catch (Exception ignored) {
            return false;
        }
    }
}
