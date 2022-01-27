package app.studies.Courses;

import app.studies.Students.Student;

import java.io.Serializable;

public class CourseResult implements Serializable {
    private static final long serialVersionUID = 15L;

    private Student student;
    private int mark;

    public CourseResult(Student student, int mark) {
        this.student = student;
        this.mark = mark;
    }

    public Student getStudent() {
        return student;
    }

    public int getMark() {
        return mark;
    }
}
