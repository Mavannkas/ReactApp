package app.studies.view.Students;

import app.studies.Listeners.ChangeViewListener;
import app.studies.view.Builders.PanelBag;

import javax.swing.*;

public class StudentsPanel extends PanelBag {
    private JButton addStudentViewButton;
    private JButton showStudentsViewButton;
    private JButton goBackButton;

    public StudentsPanel(ChangeViewListener goBackListener) {
        super(goBackListener);
    }

    protected void createComponents() {
        createBasicComponents("Wybierz co chcesz zrobić");

        leftButton = new JButton("Dodaj studenta");
//        studentsViewButton.addActionListener();
        rightButton = new JButton("Wyświetl listę studentów");
//        workersViewButton.addActionListener();

        addThreeButtons();
    }
}
