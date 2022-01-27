package app.studies.view.courses;

import app.studies.Listeners.ChangeViewListener;
import app.studies.view.Builders.PanelBag;

import javax.swing.*;

public class CoursePanel extends PanelBag {
    public CoursePanel(ChangeViewListener goBackListener) {
        super(goBackListener);
    }

    protected void createComponents() {
        createBasicComponents("Wybierz co chcesz zrobić");

        leftButton = new JButton("Dodaj kurs");
//        studentsViewButton.addActionListener();
        rightButton = new JButton("Wyświetl listę kursów");
//        workersViewButton.addActionListener();
        addThreeButtons();

    }
}
