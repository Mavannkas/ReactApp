package app.studies.controller.Students;

import app.studies.EventManager.EventManager;
import app.studies.Listeners.ChangeViewListener;
import app.studies.Students.Student;
import app.studies.controller.BasicController;
import app.studies.controller.RootControler;
import app.studies.services.StudentsService;
import app.studies.view.Frame;
import app.studies.view.Students.StudentsPanel;

import javax.swing.*;
import java.util.Map;

public class StudentsController implements BasicController, RootControler {
    private final EventManager courseManager;
    private StudentsService studentsService;
    private final Frame mainFrame;
    private final StudentsPanel studentsPanel;

    private final ChangeViewListener backTo;

    private final StudentsAddController studentsAddController;
    private final StudentsListController studentsListController;

    private final ChangeViewListener goToAdd;
    private final ChangeViewListener goToList;

    public StudentsController(Frame mainFrame, ChangeViewListener back, StudentsService studentsService, EventManager courseManager) {
        this.mainFrame = mainFrame;
        this.studentsPanel = new StudentsPanel(back);
        this.studentsService = studentsService;

        this.courseManager = courseManager;



        backTo = new ChangeViewListener(mainFrame, studentsPanel);

        studentsAddController = new StudentsAddController(mainFrame,this, backTo);
        studentsListController = new StudentsListController(mainFrame,this,  backTo, studentsService.getStudentsArray());

        goToAdd = new ChangeViewListener(mainFrame, studentsAddController.getPanel());
        goToList = new ChangeViewListener(mainFrame, studentsListController.getPanel());

        studentsPanel.addGoToListeners(goToAdd, goToList);
    }

    @Override
    public JPanel getPanel() {
        return studentsPanel;
    }

    public void process(Map<String, String> map) {
        studentsService.addStudent(
                map.get("name"),
                map.get("surname"),
                Integer.parseInt(map.get("birth")),
                map.get("year")
        );

        courseManager.notify(studentsService.getStudentsArray());
        studentsListController.update(studentsService.getStudentsArray());
    }

    public void update() {
        studentsListController.update(studentsService.getStudentsArray());
    }

    @Override
    public void delete(int ID) {
        studentsService.deleteStudent(ID);

        studentsListController.update(studentsService.getStudentsArray());
    }

    @Override
    public void details(int ID) {

    }
}
