package app.studies.view;

import app.studies.Listeners.ChangeViewListener;
import app.studies.view.Builders.PanelBag;

import javax.swing.*;
import java.awt.*;

public class HelloPanel extends PanelBag {
    private JButton studentsViewButton;
    private JButton workersViewButton;
    private JButton coursesViewButton;

    private ChangeViewListener goToWorkerPanel;
    private ChangeViewListener goToStudentsPanel;
    private ChangeViewListener goToCursesPanel;


    public HelloPanel() {
        super(null);

    }

    public void addListeners(ChangeViewListener goToWorkerPanel, ChangeViewListener goToStudentsPanel, ChangeViewListener goToCursesPanel) {
        studentsViewButton = new JButton("Studenci");
        workersViewButton = new JButton("Pracownicy");
        coursesViewButton = new JButton("Kursy");

        this.goToWorkerPanel = goToWorkerPanel;
        this.goToStudentsPanel = goToStudentsPanel;
        this.goToCursesPanel = goToCursesPanel;

        studentsViewButton.addActionListener(goToStudentsPanel);
        workersViewButton.addActionListener(goToWorkerPanel);
        coursesViewButton.addActionListener(goToCursesPanel);

        JPanel buttons = new JPanel();
        buttons.setLayout(new GridLayout(1, 3));
        buttons.add(studentsViewButton);
        buttons.add(workersViewButton);
        buttons.add(coursesViewButton);
        parent.add(buttons);
    }

    protected void createComponents() {
        createBasicComponents("Wybierz sekcję");
    }


}
