package app.studies.controller.Workers;

import app.studies.Listeners.ChangeViewListener;
import app.studies.Listeners.InputListener;
import app.studies.controller.BasicController;
import app.studies.controller.RootControler;
import app.studies.view.Frame;
import app.studies.view.Students.AddStudent;
import app.studies.view.Workers.WorkerAdd;

import javax.swing.*;

public class WorkerAddController implements BasicController {
    private Frame mainFrame;
    private WorkerAdd workerAdd;

    private final ChangeViewListener backTo;
    private InputListener inputListener;

    public WorkerAddController(Frame mainFrame, RootControler parent, ChangeViewListener back) {
        this.mainFrame = mainFrame;
        inputListener = new InputListener(mainFrame, parent);

        this.workerAdd = new WorkerAdd(back, inputListener);
        backTo = new ChangeViewListener(mainFrame, workerAdd);

    }

    @Override
    public JPanel getPanel() {
        return workerAdd;
    }
}
