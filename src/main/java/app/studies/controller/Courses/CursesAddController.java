package app.studies.controller.Courses;

import app.studies.EventManager.EventManager;
import app.studies.EventManager.WorkerUpdateListener;
import app.studies.Listeners.ChangeViewListener;
import app.studies.Listeners.InputListener;
import app.studies.Students.Student;
import app.studies.Worker.DidacticWorker;
import app.studies.Worker.Worker;
import app.studies.controller.BasicController;
import app.studies.controller.RootControler;
import app.studies.services.StudentsService;
import app.studies.services.WorkerService;
import app.studies.view.Frame;
import app.studies.view.courses.CourseAdd;
import app.studies.view.courses.CoursePanel;
import app.studies.view.courses.CursesList;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class CursesAddController implements BasicController {
    private final WorkerService workerService;
    private Frame mainFrame;
    private CourseAdd courseAdd;

    private final ChangeViewListener backTo;
    private final InputListener inputListener;

    public CursesAddController(Frame mainFrame, RootControler parent, ChangeViewListener back, WorkerService workerService, EventManager courseManager) {
        this.mainFrame = mainFrame;
        this.workerService = workerService;

        this.inputListener = new InputListener(mainFrame, parent);

        this.courseAdd = new CourseAdd(back, inputListener, parseWorkers(workerService.getWorkersArray()));
        backTo = new ChangeViewListener(mainFrame, courseAdd);

        courseManager.subscribe(new WorkerUpdateListener(this));

    }

    private String[] parseWorkers(Worker[] workers) {
        Set<String> didacticWorkers = new TreeSet<>();

        for(Worker worker: workers) {
            if(worker instanceof DidacticWorker) {
                DidacticWorker didactic = (DidacticWorker) worker;
                didacticWorkers.add(didactic.getID() + "-" + didactic.getPerson().getName() + "_" + didactic.getPerson().getSurname());
            }
        }

        return didacticWorkers.toArray(new String[0]);
    }

    public void update(Worker[] workers) {
        courseAdd.setNames(parseWorkers(workers));
    }

    @Override
    public JPanel getPanel() {
        return courseAdd;
    }
}
