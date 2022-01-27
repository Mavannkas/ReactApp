package app.studies.Students;

import app.studies.Person.Person;

import java.io.Serializable;

public class Student implements Comparable<Student>, Serializable {
    private static final long serialVersionUID = 1L;
    private int ID;
    private Person person;
    private String year;

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    private String additionalInfo;

    public Student(int ID, Person person, String year, String additionalInfo) {
        this.ID = ID;
        this.person = person;
        this.year = year;
        this.additionalInfo = additionalInfo;
    }

    public int getID() {
        return ID;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public int compareTo(Student o) {
        return ID - o.ID;
    }
}
