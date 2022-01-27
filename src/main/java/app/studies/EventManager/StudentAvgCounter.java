package app.studies.EventManager;

import app.studies.Courses.Course;
import app.studies.Courses.CourseResult;
import app.studies.Students.Student;
import app.studies.controller.Students.StudentsController;
import app.studies.services.StudentsService;

import java.util.Set;

public class StudentAvgCounter {
    protected StudentsController studentsController;
    protected StudentsService studentsService;
    protected Student student;
    protected Set<Course> courses;

    public StudentAvgCounter(Set<Course> courses, StudentsService studentsService, StudentsController studentsController) {
        this.courses = courses;
        this.studentsService = studentsService;
        this.studentsController = studentsController;
    }

    public double getAVG() {
        int counter = 0;
        int sum = 0;
        for(Course course : courses) {
            for(CourseResult courseResult : course.getCourseResults()) {
                if(courseResult.getStudent().getID() == student.getID()) {
                    counter++;
                    sum +=  courseResult.getMark();
                }
            }
        }

        return sum / (double) counter;
    }
}
