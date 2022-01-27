package app.studies.services;

import app.studies.Courses.Course;
import app.studies.Courses.CourseResult;
import app.studies.Person.Person;
import app.studies.Students.Student;

import java.io.IOException;
import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

public class CourseService extends BasicService<Set<Course>> {
    private final String PATH = "./courses.db";
    private final Set<Course> courses = new TreeSet<>();

    public CourseService() {
        try {
            readObjects();
        } catch (IOException | ClassNotFoundException err) {
            System.out.println(err.getMessage());
        }
    }

    public void addCourse(String name, int ECTS, int hours, String type, String leader) {
        Course course = new Course(getLastCourseID() + 1, name, ECTS, hours, type, leader);
        courses.add(course);
        saveObjects();
    }

    public void addResultByID(int ID, CourseResult courseResult) {
        for(Course course : courses) {
            if(course.getID() == ID) {
                course.addCourseResult(courseResult);
            }
        }

        saveObjects();
    }

    public void deleteCourse(int id) {
        for(Course course : courses) {
            if(course.getID() == id) {
                courses.remove(course);
                break;
            }
        }
        saveObjects();
    }

    private int getLastCourseID() {
        Course lastCourse = null;
        for(Course course : courses) {
            lastCourse = course;
        }
        return lastCourse != null ? lastCourse.getID() : -1;
    }

    @Override
    public void readObjects() throws IOException, ClassNotFoundException {
        Collection<Course> courses = readFile(PATH);
        if(courses != null) {
            this.courses.addAll(courses);
        }
    }

    @Override
    public void saveObjects() {
        try {

        writeToFile(courses, PATH);
        } catch (IOException err) {}
    }

    public Course[] getCoursesArray() {
        return courses.toArray(new Course[0]);
    }

    public Set<Course> getCourses() {
        return courses;
    }

}
