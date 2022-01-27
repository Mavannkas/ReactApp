package app.studies.controller.Workers;

import app.studies.EventManager.EventManager;
import app.studies.Listeners.ChangeViewListener;
import app.studies.Worker.Worker;
import app.studies.controller.BasicController;
import app.studies.controller.RootControler;
import app.studies.services.StudentsService;
import app.studies.services.WorkerService;
import app.studies.view.Frame;
import app.studies.view.Workers.WorkerPanel;

import javax.swing.*;
import java.util.Map;

public class WorkerController implements BasicController, RootControler {
    private final EventManager courseManager;
    private WorkerService workerService;

    private Frame mainFrame;
    private WorkerPanel workerPanel;

    private final ChangeViewListener backTo;

    private final WorkerAddController workerAddController;
    private final WorkerListController workerListController;

    private final ChangeViewListener goToAddWorker;
    private final ChangeViewListener goToWorkerList;


    public WorkerController(Frame mainFrame, ChangeViewListener back, WorkerService workerService, EventManager courseManager) {
        this.workerService = workerService;
        this.mainFrame = mainFrame;
        this.workerPanel = new WorkerPanel(back);

        this.courseManager = courseManager;

        backTo = new ChangeViewListener(mainFrame, workerPanel);

        workerAddController = new WorkerAddController(mainFrame, this, backTo);
        workerListController = new WorkerListController(mainFrame, this, backTo, workerService.getWorkersArray());

        goToAddWorker = new ChangeViewListener(mainFrame, workerAddController.getPanel());
        goToWorkerList = new ChangeViewListener(mainFrame, workerListController.getPanel());



        workerPanel.addGoToListeners(goToAddWorker, goToWorkerList);

    }

    @Override
    public JPanel getPanel() {
        return workerPanel;
    }

    @Override
    public void process(Map<String, String> map) {
        if(map.get("type").equals("N/D")) {
            workerService.addDidacticWorker(
                    map.get("name"),
                    map.get("surname"),
                    Integer.parseInt(map.get("birth")),
                    Integer.parseInt(map.get("hours")),
                    Integer.parseInt(map.get("salary")),
                    Integer.parseInt(map.get("cursesCount")),
                    Integer.parseInt(map.get("publicCount"))
            );
        } else {
            workerService.addAdministration(
                    map.get("name"),
                    map.get("surname"),
                    Integer.parseInt(map.get("birth")),
                    Integer.parseInt(map.get("hours")),
                    Integer.parseInt(map.get("salary")),
                    Integer.parseInt(map.get("languages")),
                    map.get("shift")
            );
        }

        courseManager.notify(workerService.getWorkersArray());
        workerListController.update(workerService.getWorkersArray());
    }


    @Override
    public void delete(int ID) {
        workerService.deleteWorker(ID);

        workerListController.update(workerService.getWorkersArray());
    }

    @Override
    public void details(int ID) {

    }
}
