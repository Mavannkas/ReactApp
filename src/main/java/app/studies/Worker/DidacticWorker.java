package app.studies.Worker;

import app.studies.Person.Person;

import java.io.Serializable;

public class DidacticWorker extends Worker implements Serializable {
    private static final long serialVersionUID = 7L;
    private int coursesCount;
    private int publications;

    public DidacticWorker(int ID, Person person, int hoursPerMonth, int salary, int coursesCount, int publications) {
        super(ID, person, hoursPerMonth, salary, "Dydaktyczny");
        this.coursesCount = coursesCount;
        this.publications = publications;
    }


    public int getCoursesCount() {
        return coursesCount;
    }

    public void setCoursesCount(int coursesCount) {
        this.coursesCount = coursesCount;
    }

    public int getPublications() {
        return publications;
    }

    public void setPublications(int publications) {
        this.publications = publications;
    }
}
