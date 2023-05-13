package com.otus.steps;

import com.google.inject.Inject;
import com.otus.pages.TrainingCoursesPage;
import io.cucumber.java.ru.Если;
import io.cucumber.java.ru.Пусть;
import io.cucumber.java.ru.Тогда;

public class TrainingCoursesPageSteps {

    @Inject
    private TrainingCoursesPage trainingCoursesPage;

    @Пусть("Открыта страница подготовительных курсов")
    public void openPage() {
        trainingCoursesPage.open();
    }

    @Если("Выбран самый дешёвый курс")
    public void chooseCheaper() {
        trainingCoursesPage.getCheapExpensiveCourse(true);
    }

    @Если("Выбран самый дорогой курс")
    public void choseMoreExpensive () {
        trainingCoursesPage.getCheapExpensiveCourse(false);
    }

    @Тогда("Откроется верная страница")
    public void откроетсяВернаяСтраница() {
    }
}
