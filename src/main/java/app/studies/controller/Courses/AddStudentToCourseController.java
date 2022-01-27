package app.studies.controller.Courses;

import app.studies.Courses.CourseResult;
import app.studies.EventManager.EventManager;
import app.studies.EventManager.StudentUpdateListener;
import app.studies.EventManager.WorkerUpdateListener;
import app.studies.Listeners.ChangeViewListener;
import app.studies.Listeners.InputListener;
import app.studies.Students.Student;
import app.studies.Worker.DidacticWorker;
import app.studies.Worker.Worker;
import app.studies.controller.BasicController;
import app.studies.controller.RootControler;
import app.studies.controller.Workers.WorkerListController;
import app.studies.services.CourseService;
import app.studies.services.StudentsService;
import app.studies.services.WorkerService;
import app.studies.view.Frame;
import app.studies.view.Workers.GetSalary;
import app.studies.view.courses.AddStudentToCourse;

import javax.swing.*;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class AddStudentToCourseController implements BasicController, RootControler {
    private final InputListener inputListener;
    private final CourseService courseService;
    private final StudentsService studentsService;
    private final EventManager courseManager;
    private Frame mainFrame;
    private AddStudentToCourse addStudentToCourse;

    public AddStudentToCourseController(Frame mainFrame, ChangeViewListener back, StudentsService studentsService, CourseService courseService, EventManager courseManager) {
        this.mainFrame = mainFrame;
        this.studentsService = studentsService;
        this.inputListener = new InputListener(mainFrame, this);
        this.addStudentToCourse = new AddStudentToCourse(back, inputListener, parseStudents(studentsService.getStudentsArray()));
        this.courseService = courseService;
        this.courseManager = courseManager;

        courseManager.subscribe(new StudentUpdateListener(this));
    }

    private String[] parseStudents(Student[] students) {
        Set<String> studentsLabels = new TreeSet<>();

        for(Student student: students) {
            studentsLabels.add(student.getID() + "-" + student.getPerson().getName() + "_" + student.getPerson().getSurname());
        }

        return studentsLabels.toArray(new String[0]);
    }

    @Override
    public JPanel getPanel() {
        return addStudentToCourse;
    }

    @Override
    public void delete(int ID) {

    }

    @Override
    public void process(Map<String, String> map) {
        Student student = getStudentByID(map.get("students"));
        courseService.addResultByID(addStudentToCourse.getID(), new CourseResult(student, Integer.parseInt(map.get("mark"))));
        courseManager.notify(student);
    }

    private Student getStudentByID(String studentString) {
        int ID = Integer.parseInt(studentString.split("-")[0]);
        for(Student student : studentsService.getStudentsArray()) {
            if(student.getID() == ID) {
                return student;
            }
        }
        return null;
    }

    @Override
    public void details(int ID) {
    }

    public void update(Student[] students) {
        addStudentToCourse.setNames(parseStudents(students));
    }
}
