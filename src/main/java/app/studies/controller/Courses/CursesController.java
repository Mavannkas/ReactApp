package app.studies.controller.Courses;

import app.studies.EventManager.*;
import app.studies.Listeners.ChangeViewListener;
import app.studies.controller.BasicController;
import app.studies.controller.RootControler;
import app.studies.controller.Students.StudentsController;
import app.studies.services.CourseService;
import app.studies.services.StudentsService;
import app.studies.services.WorkerService;
import app.studies.view.Frame;
import app.studies.view.courses.CoursePanel;

import javax.swing.*;
import java.util.Map;

public class CursesController implements BasicController, RootControler {
    private final CourseService courseService = new CourseService();


    private Frame mainFrame;
    private CoursePanel coursePanel;

    private final ChangeViewListener backTo;

    private final CursesAddController cursesAddController;
    private final CursesListController cursesListController;

    private final ChangeViewListener goToAdd;
    private final ChangeViewListener goToList;

    public CursesController(Frame mainFrame, ChangeViewListener back, WorkerService workerService, EventManager courseManager, StudentsService studentsService, StudentsController studentsController) {
        this.mainFrame = mainFrame;
        this.coursePanel = new CoursePanel(back);
        backTo = new ChangeViewListener(mainFrame, coursePanel);

        courseManager.subscribe(new StudentNormalListener(courseService.getCourses(), studentsService, studentsController, this));
        courseManager.subscribe(new StudentOutListener(courseService.getCourses(), studentsService, studentsController, this));
        courseManager.subscribe(new StudentScholarListener(courseService.getCourses(), studentsService, studentsController, this));

        cursesAddController = new CursesAddController(mainFrame,this, backTo, workerService, courseManager);
        cursesListController = new CursesListController(mainFrame, this, backTo, courseService.getCoursesArray(), studentsService, courseService,  courseManager);

        goToAdd = new ChangeViewListener(mainFrame, cursesAddController.getPanel());
        goToList = new ChangeViewListener(mainFrame, cursesListController.getPanel());

        coursePanel.addGoToListeners(goToAdd, goToList);
    }

    @Override
    public JPanel getPanel() {
        return coursePanel;
    }

    @Override
    public void delete(int ID) {
        courseService.deleteCourse(ID);

        cursesListController.update(courseService.getCoursesArray());
    }

    @Override
    public void process(Map<String, String> map) {
        courseService.addCourse(
                map.get("name"),
                Integer.parseInt(map.get("ects")),
                Integer.parseInt(map.get("hours")),
                map.get("type"),
                map.get("leader")
        );

        cursesListController.update(courseService.getCoursesArray());
    }

    @Override
    public void details(int ID) {

    }

    public void update() {
        cursesListController.update(courseService.getCoursesArray());
    }
}
