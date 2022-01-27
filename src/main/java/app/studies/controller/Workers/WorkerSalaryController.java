package app.studies.controller.Workers;

import app.studies.Listeners.ChangeViewListener;
import app.studies.Listeners.InputListener;
import app.studies.controller.BasicController;
import app.studies.controller.RootControler;
import app.studies.view.Frame;
import app.studies.view.Workers.GetSalary;
import app.studies.view.Workers.WorkerAdd;

import javax.swing.*;
import java.util.Map;

public class WorkerSalaryController implements BasicController, RootControler {
    private final InputListener inputListener;
    private final WorkerListController parent;
    private Frame mainFrame;
    private GetSalary getSalary;

    public WorkerSalaryController(Frame mainFrame,WorkerListController parent, ChangeViewListener back) {
        this.mainFrame = mainFrame;
        this.inputListener = new InputListener(mainFrame, this);
        this.parent = parent;
        this.getSalary = new GetSalary(back, inputListener);

    }

    @Override
    public JPanel getPanel() {
        return getSalary;
    }

    @Override
    public void delete(int ID) {

    }

    @Override
    public void process(Map<String, String> map) {
        parent.showSalary(getSalary.getID(), map.get("type"));
    }

    @Override
    public void details(int ID) {
    }
}
