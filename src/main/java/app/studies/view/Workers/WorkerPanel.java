package app.studies.view.Workers;

import app.studies.Listeners.ChangeViewListener;
import app.studies.view.Builders.PanelBag;

import javax.swing.*;

public class WorkerPanel extends PanelBag {

    public WorkerPanel(ChangeViewListener goBackListener) {
        super(goBackListener);
    }

    protected void createComponents() {
        createBasicComponents("Wybierz co chcesz zrobić");

        leftButton = new JButton("Dodaj pracownika");
//        studentsViewButton.addActionListener();
        rightButton = new JButton("Wyświetl listę pracowników");
//        workersViewButton.addActionListener();
        addThreeButtons();

    }
}
