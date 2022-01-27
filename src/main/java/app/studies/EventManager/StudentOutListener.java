package app.studies.EventManager;

import app.studies.Courses.Course;
import app.studies.Courses.CourseResult;
import app.studies.Students.Student;
import app.studies.controller.Courses.CursesController;
import app.studies.controller.Students.StudentsController;
import app.studies.services.StudentsService;

import java.util.Set;

public class StudentOutListener extends StudentAvgCounter implements EventListener {
    private final CursesController coursesController;

    public StudentOutListener(Set<Course> courses, StudentsService studentsService, StudentsController studentsController,  CursesController coursesController) {
        super(courses, studentsService, studentsController);
        this.coursesController = coursesController;
    }

    @Override
    public void update(Object o) {
        if(o instanceof Student) {
            this.student = (Student) o;
            int counter = 0;


            for(Course course : courses) {
                for(CourseResult courseResult : course.getCourseResults()) {
                    if(courseResult.getStudent().getID() == student.getID()) {
                        if(courseResult.getMark() < 3.0) {
                            counter++;
                            break;
                        }
                    }
                }
            }

            if(counter >= 3) {
                studentsService.updateStudentByID(student.getID(), "Zagrożony");
                studentsController.update();
                coursesController.update();
            }
        }
    }
}
