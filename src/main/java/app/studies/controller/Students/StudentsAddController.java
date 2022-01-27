package app.studies.controller.Students;

import app.studies.Listeners.ChangeViewListener;
import app.studies.Listeners.InputListener;
import app.studies.controller.BasicController;
import app.studies.controller.RootControler;
import app.studies.view.Frame;
import app.studies.view.Students.AddStudent;
import app.studies.view.Students.StudentsList;

import javax.swing.*;

public class StudentsAddController implements BasicController {
    private Frame mainFrame;
    private AddStudent addStudent;

    private final ChangeViewListener backTo;
    private final InputListener inputListener;

    public StudentsAddController(Frame mainFrame, RootControler parent, ChangeViewListener back) {
        this.mainFrame = mainFrame;

        this.inputListener = new InputListener(mainFrame, parent);

        this.addStudent = new AddStudent(back, inputListener);
        backTo = new ChangeViewListener(mainFrame, addStudent);

    }

    @Override
    public JPanel getPanel() {
        return addStudent;
    }
}
