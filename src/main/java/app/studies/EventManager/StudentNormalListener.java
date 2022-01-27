package app.studies.EventManager;

import app.studies.Courses.Course;
import app.studies.Students.Student;
import app.studies.controller.Courses.CursesController;
import app.studies.controller.Students.StudentsController;
import app.studies.services.StudentsService;

import java.util.Set;

public class StudentNormalListener extends StudentAvgCounter implements EventListener {

    private final CursesController coursesController;

    public StudentNormalListener(Set<Course> courses, StudentsService studentsService, StudentsController studentsController, CursesController coursesController) {
        super(courses, studentsService, studentsController);
        this.coursesController = coursesController;
    }

    @Override
    public void update(Object o) {
        if(o instanceof Student) {
            this.student = (Student) o;
            double avg = getAVG();

            if(avg < 4.5) {
                studentsService.updateStudentByID(student.getID(), "N/D");
                studentsController.update();
                coursesController.update();
            }
        }
    }
}
