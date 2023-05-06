package com.otus.steps;

import com.google.inject.Inject;
import com.otus.components.CourseTile;
import io.cucumber.java.ru.Если;
import io.cucumber.java.ru.Также;
import io.cucumber.java.ru.Тогда;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.function.BinaryOperator;

public class CourseTileSteps {

    @Inject
    private CourseTile courseTile;

    @Если("Кликнуть на плитку курса {string}")
    public void clickCourseTile(String title) {
        courseTile.findCourseByTitle(title);
    }

    @Если("Кликнуть на ранний плитку курса")
    public void clickEarlierCourse() {
        courseTile.getEarlierLaterCourse(true);
    }

    @Если("Кликнуть на поздний плитку курса")
    public void clickLaterCourse() {
        courseTile.getEarlierLaterCourse(false);
    }

    @Тогда("Откроется страница курса")
    public void getCoursePage() {
    }

    @Также("Вывести название и дату курса в консоль")
    public void вывестиНазваниеИДатуКурсаВКонсоль() {

    }
}
