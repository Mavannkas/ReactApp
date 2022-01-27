package app.studies.controller.Courses;

import app.studies.Courses.Course;
import app.studies.EventManager.EventManager;
import app.studies.EventManager.WorkerUpdateListener;
import app.studies.Listeners.ChangeViewListener;
import app.studies.Listeners.CustomTableClickListener;
import app.studies.Students.Student;
import app.studies.controller.BasicController;
import app.studies.controller.RootControler;
import app.studies.services.CourseService;
import app.studies.services.StudentsService;
import app.studies.services.WorkerService;
import app.studies.view.Frame;
import app.studies.view.components.DetailsComponent;
import app.studies.view.courses.AddStudentToCourse;
import app.studies.view.courses.CourseAdd;
import app.studies.view.courses.CursesList;

import javax.swing.*;

public class CursesListController implements BasicController {
    private CourseService courseService;
    private CustomTableClickListener customTableClickListener;
    private RootControler rootControler;
    private Frame mainFrame;
    private CursesList cursesList;
    private AddStudentToCourseController addStudentToCourseController;
    private final ChangeViewListener backTo;

    public CursesListController(Frame mainFrame, RootControler rootControler, ChangeViewListener back, Course[] courses, StudentsService studentsService, CourseService courseService, EventManager courseListener) {
        this.rootControler = rootControler;
        this.mainFrame = mainFrame;
        this.courseService = courseService;

        backTo = new ChangeViewListener(mainFrame, null);

        this.addStudentToCourseController = new AddStudentToCourseController(mainFrame, backTo, studentsService, courseService, courseListener);
        this.customTableClickListener = new CustomTableClickListener(mainFrame, (DetailsComponent) addStudentToCourseController.getPanel(), rootControler);

        this.cursesList = new CursesList(back, customTableClickListener, courses);

        backTo.changePanel(cursesList);
    }

    public void update(Course[] courses) {
        System.out.println("Aktualizacja" + courses.length);
        cursesList.updateStudents(courses);
    }

    @Override
    public JPanel getPanel() {
        return cursesList;
    }
}
