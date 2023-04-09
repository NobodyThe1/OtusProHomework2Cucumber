package com.otus.steps;

import com.google.inject.Inject;
import com.otus.components.CourseTile;
import io.cucumber.java.ru.Если;

public class CourseTileSteps {

    @Inject
    private CourseTile courseTile;

    @Если("Кликнуть на плитку курса {string}")
    public void clickCourseTile(String title) {
        courseTile.findCourseByTitle(title);
    }
}
