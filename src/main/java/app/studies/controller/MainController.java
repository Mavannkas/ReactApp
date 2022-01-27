package app.studies.controller;

import app.studies.EventManager.EventListener;
import app.studies.EventManager.EventManager;
import app.studies.EventManager.WorkerUpdateListener;
import app.studies.Listeners.ChangeViewListener;
import app.studies.Worker.Worker;
import app.studies.controller.Courses.CursesController;
import app.studies.controller.Students.StudentsController;
import app.studies.controller.Workers.WorkerController;
import app.studies.services.StudentsService;
import app.studies.services.WorkerService;
import app.studies.view.Frame;
import app.studies.view.HelloPanel;

public class MainController{
    private final StudentsService studentsService = new StudentsService(); //Dodać to do kursów
    private final WorkerService workerService = new WorkerService(); //Dodać to do kursów
    private final Frame mainFrame = new Frame();
    private final HelloPanel helloPanel = new HelloPanel();

    private final ChangeViewListener backToHome = new ChangeViewListener(mainFrame, helloPanel);
    private final EventManager courseManager = new EventManager();

    private final WorkerController workerController = new WorkerController(mainFrame, backToHome, workerService, courseManager);
    private final StudentsController studentsController = new StudentsController(mainFrame, backToHome, studentsService, courseManager);
    private final CursesController cursesController = new CursesController(mainFrame, backToHome, workerService, courseManager, studentsService, studentsController);


    private final ChangeViewListener goToWorkerPanel = new ChangeViewListener(mainFrame, workerController.getPanel());
    private final ChangeViewListener goToStudentsPanel = new ChangeViewListener(mainFrame, studentsController.getPanel());
    private final ChangeViewListener goToCursesPanel = new ChangeViewListener(mainFrame, cursesController.getPanel());




    public MainController() {
        helloPanel.addListeners(goToWorkerPanel, goToStudentsPanel, goToCursesPanel);
        mainFrame.updatePanel(helloPanel);
    }



}
