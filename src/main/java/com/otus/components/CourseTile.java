package com.otus.components;

import com.google.inject.Inject;
import com.otus.data.MonthData;
import com.otus.di.GuiceScoped;
import com.otus.pages.AnyPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.BinaryOperator;

import java.time.LocalDate;
import java.util.stream.Stream;

public class CourseTile extends AbsComponent<CourseTile> {

    @Inject
    public CourseTile(GuiceScoped guiceScoped) {
        super(guiceScoped);
    }

    @FindBy (css = "[class='lessons'] .lessons__new-item-start, [class='lessons'] .lessons__new-item-bottom > .lessons__new-item-time")
    private List<WebElement> courseList;

    public void getEarlierLaterCourse(boolean isEarlier) {

        BinaryOperator<LocalDate> reduceImpl = null;
        if (isEarlier) {
            reduceImpl = (LocalDate x, LocalDate y) -> x.isBefore(y) ? y : x;
        } else {
            reduceImpl = (LocalDate x, LocalDate y) -> x.isBefore(y) ? y : y;
        }

        courseList.stream()
                .filter((WebElement element) -> !element.getText().equals("О дате старта будет объявлено позже"))
                .map((WebElement element) -> {
                    String dateString = element.getText().replaceAll("^С", "").trim();
                    dateString = dateString.replaceAll("\\s+\\d+\\s.*", "");

                    String month = dateString.split("\\s+")[1];
                    dateString = dateString.replaceAll("[а-я]+",
                            String.format("%d", MonthData.getDate(month).getNumber())) + " " + LocalDate.now().getYear();
                    return LocalDate.parse(dateString, DateTimeFormatter.ofPattern("d M yyyy"));
                })
                .reduce(reduceImpl)
                .map((LocalDate localDate) -> {
                    String finalDate = localDate.format(DateTimeFormatter.ofPattern("d MMMM", new Locale("RU", "ru")));
                    System.out.println(finalDate);
                    return finalDate.replaceAll("\\s+\\d+$", String.format("%s", MonthData.getName(localDate.getMonthValue())));
                })
                .map((String finalDate) -> {
                    WebElement element = guiceScoped.driver.findElement(By.xpath(String.format(courseTitleLocator, finalDate)));
                    return ((JavascriptExecutor)guiceScoped.driver).executeScript("arguments[0].click()", element);
                });
    }

    public void moveToCourse(String title) {
        moveAndPerform(guiceScoped.driver.findElement(By.xpath(String.format(courseTitleLocator, title))));
    }
    public void findCourseByTitle(String title) {
        moveAndClick(guiceScoped.driver.findElement(By.xpath(String.format(courseTitleLocator, title))));
    }
}
