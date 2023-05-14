package com.otus.pages;

import com.google.inject.Inject;
import com.otus.annotations.Path;
import com.otus.data.MonthData;
import com.otus.di.GuiceScoped;
import org.jsoup.select.Collector;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.function.BinaryOperator;

@Path("/online")
public class TrainingCoursesPage extends AbsPage<TrainingCoursesPage> {

    @Inject
    public TrainingCoursesPage (GuiceScoped guiceScoped) {
        super(guiceScoped);
    }

    @FindBy(css = ".lessons__new-item-price")
    List<WebElement> onlinecourseList;

    private String coursePriceLocator = "//*[contains(@class, 'lessons__new-item-price')][contains (text(), 's')]";

    public void getCheapExpensiveCourse(boolean isCheaper) {

        BinaryOperator<Integer> reduceImpl = null;
        if (isCheaper) {
            reduceImpl = (Integer x, Integer y) -> x <= y ? x : y;
        } else {
            reduceImpl = (Integer x, Integer y) -> x <= y ? y : x;
        }

        onlinecourseList.stream()
                .map((WebElement element) -> {
                    String textPrice = element.getText().trim();
                    textPrice = textPrice.replaceAll("\\s.*", "");
                    return Integer.parseInt(textPrice);
                })
                .reduce(reduceImpl)
                .map((Integer integer) -> {
                    String finalPrice = integer.toString();
                    System.out.println(finalPrice);
                        List<WebElement> elements = guiceScoped.driver.findElements(By.xpath(String.format(coursePriceLocator, finalPrice)));
                        return ((JavascriptExecutor)guiceScoped.driver).executeScript("arguments[0].click()", elements.get(0));
                });
    }
}
