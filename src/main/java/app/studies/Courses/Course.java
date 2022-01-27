package app.studies.Courses;

import app.studies.Person.Person;
import app.studies.Students.Student;

import java.io.Serializable;
import java.util.ArrayList;

public class Course implements Comparable<Course>, Serializable {
    private static final long serialVersionUID = 5L;
    private int ID;
    private String name;
    private int ECTS;
    private int hours;
    private String type;
    private String leader;

    public ArrayList<CourseResult> getCourseResults() {
        return courseResults;
    }

    private final ArrayList<CourseResult> courseResults = new ArrayList<>();

    public Course(int ID, String name, int ECTS, int hours, String type, String leader) {
        this.ID = ID;
        this.name = name;
        this.ECTS = ECTS;
        this.hours = hours;
        this.type = type;
        this.leader = leader;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getECTS() {
        return ECTS;
    }

    public void setECTS(int ECTS) {
        this.ECTS = ECTS;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public String getLeader() {
        return leader;
    }

    public void addCourseResult(CourseResult courseResult) {
        courseResults.add(courseResult);
    }

    public void setLeader(String  leader) {
        this.leader = leader;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int compareTo(Course o) {
        return ID - o.ID;
    }
}
