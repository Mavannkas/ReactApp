package app.studies.controller.Workers;

import app.studies.SalaryStrategies.AdministrationCustomSalary;
import app.studies.SalaryStrategies.DidacticCustomSalary;
import app.studies.SalaryStrategies.SalaryStrategy;
import app.studies.SalaryStrategies.UniversalSalaryCounter;
import app.studies.Listeners.ChangeViewListener;
import app.studies.Listeners.CustomTableClickListener;
import app.studies.Worker.DidacticWorker;
import app.studies.Worker.Worker;
import app.studies.controller.BasicController;
import app.studies.controller.RootControler;
import app.studies.view.Frame;
import app.studies.view.Workers.WorkersList;
import app.studies.view.components.DetailsComponent;

import javax.swing.*;
import java.util.Objects;

public class WorkerListController implements BasicController {
    private Worker[] workers;
    private CustomTableClickListener customTableClickListener;
    private RootControler rootControler;
    private Frame mainFrame;
    private WorkersList workersList;

    private final WorkerSalaryController workerSalaryController;
    private final ChangeViewListener goToWorkerSalary;

    private final ChangeViewListener backTo;

    public WorkerListController(Frame mainFrame, RootControler rootControler, ChangeViewListener back, Worker[] workers) {
        this.rootControler = rootControler;
        this.mainFrame = mainFrame;

        backTo = new ChangeViewListener(mainFrame, null);
        workerSalaryController = new WorkerSalaryController(mainFrame,this, backTo);
        this.workers = workers;

        this.customTableClickListener = new CustomTableClickListener(mainFrame, (DetailsComponent) workerSalaryController.getPanel(), rootControler);
        this.workersList = new WorkersList(back, customTableClickListener, workers);

        backTo.changePanel(workersList);
        goToWorkerSalary = new ChangeViewListener(mainFrame, workerSalaryController.getPanel());



    }

    public void update(Worker[] workers) {
        System.out.println("Aktualizacja" + workers.length);
        this.workers = workers;
        workersList.updateWorkers(workers);
    }

    public void showSalary(int ID, String version) {
        Worker worker =  getWorkerByID(ID);
        SalaryStrategy salaryStrategy;

        if(Objects.equals(version, "v1")) {
            salaryStrategy = new UniversalSalaryCounter();
       } else {
            if(worker instanceof DidacticWorker) {
                salaryStrategy = new DidacticCustomSalary();
            } else {
                salaryStrategy = new AdministrationCustomSalary();
            }
        }

        JOptionPane.showMessageDialog(null, "Wypłata=" + salaryStrategy.getSalary(worker));
    }

    private Worker getWorkerByID(int id) {
        for(Worker tempWorker : workers) {
            if(tempWorker.getID() == id) {
                return tempWorker;
            }
        }
        return null;
    }

    @Override
    public JPanel getPanel() {
        return workersList;
    }
}
