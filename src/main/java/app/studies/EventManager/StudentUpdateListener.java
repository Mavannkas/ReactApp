package app.studies.EventManager;

import app.studies.Students.Student;
import app.studies.Worker.Worker;
import app.studies.controller.Courses.AddStudentToCourseController;
import app.studies.controller.Courses.CursesAddController;

public class StudentUpdateListener implements EventListener{
    private AddStudentToCourseController addStudentToCourseController;

    public StudentUpdateListener(AddStudentToCourseController addStudentToCourseController) {
        this.addStudentToCourseController = addStudentToCourseController;
    }

    @Override
    public void update(Object o) {
        if(o instanceof Student[]) {
            addStudentToCourseController.update((Student[]) o);
        }
    }
}
