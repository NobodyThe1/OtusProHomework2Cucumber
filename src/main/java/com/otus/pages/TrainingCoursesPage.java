package com.otus.pages;

import com.google.inject.Inject;
import com.otus.annotations.Path;
import com.otus.di.GuiceScoped;

@Path("/online")
public class TrainingCoursesPage extends AbsPage<TrainingCoursesPage> {

    @Inject
    public TrainingCoursesPage (GuiceScoped guiceScoped) {
        super(guiceScoped);
    }
}
