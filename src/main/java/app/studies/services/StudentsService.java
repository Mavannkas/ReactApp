package app.studies.services;

import app.studies.Person.Person;
import app.studies.Students.Student;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class StudentsService extends BasicService<Set<Student>> {
    private final String PATH = "./students.db";
    private final Set<Student> students = new TreeSet<Student>();

    public StudentsService() {
        try {
            readObjects();
        } catch (IOException | ClassNotFoundException err) {
            System.out.println(err.getMessage());
        }
    }

    public void addStudent(String name, String surname, int birthYear, String year) {
        Person person = new Person(name, surname, birthYear);
        Student student = new Student(getLastStudentID() + 1, person, year, "N/D");
        students.add(student);
        saveObjects();
    }

    public void updateStudentByID(int ID, String info) {
        for(Student student : students) {
            if(student.getID() == ID) {
                student.setAdditionalInfo(info);
                break;
            }
        }

        saveObjects();
    }

    public void deleteStudent(int id) {
        for(Student student : students) {
            if(student.getID() == id) {
                students.remove(student);
                break;
            }
        }
        saveObjects();
    }

    private int getLastStudentID() {
        Student lastStudent = null;
        for(Student student : students) {
            lastStudent = student;
        }
        return lastStudent != null ? lastStudent.getID() : -1;
    }

    @Override
    public void readObjects() throws IOException, ClassNotFoundException {
        Collection<Student> students = readFile(PATH);
        if(students != null) {
            this.students.addAll(students);
        }
    }

    @Override
    public void saveObjects() {
        try {

        writeToFile(students, PATH);
        } catch (IOException err) {}
    }

    public Student[] getStudentsArray() {
        return students.toArray(new Student[0]);
    }

}
