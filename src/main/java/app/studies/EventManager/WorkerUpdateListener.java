package app.studies.EventManager;

import app.studies.Students.Student;
import app.studies.Worker.Worker;
import app.studies.controller.Courses.CursesAddController;
import app.studies.view.courses.CourseAdd;

public class WorkerUpdateListener implements EventListener{
    private CursesAddController cursesAddController;

    public WorkerUpdateListener(CursesAddController cursesAddController) {
        this.cursesAddController = cursesAddController;
    }

    @Override
    public void update(Object o) {
        if(o instanceof Worker[]) {
            cursesAddController.update((Worker[]) o);
        }
    }
}
