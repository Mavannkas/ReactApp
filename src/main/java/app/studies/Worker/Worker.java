package app.studies.Worker;

import app.studies.Person.Person;
import app.studies.Students.Student;

import java.io.Serializable;

public class Worker implements Comparable<Worker>, Serializable {
    private static final long serialVersionUID = 5L;
    private int ID;
    private Person person;
    private int hoursPerMonth;
    private int salary;
    private String type;

    public Worker(int ID, Person person, int hoursPerMonth, int salary, String type) {
        this.ID = ID;
        this.person = person;
        this.hoursPerMonth = hoursPerMonth;
        this.salary = salary;
        this.type = type;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public int getHoursPerMonth() {
        return hoursPerMonth;
    }

    public void setHoursPerMonth(int hoursPerMonth) {
        this.hoursPerMonth = hoursPerMonth;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int compareTo(Worker o) {
        return ID - o.ID;
    }
}
