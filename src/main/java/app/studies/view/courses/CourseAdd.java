package app.studies.view.courses;

import app.studies.Listeners.ChangeViewListener;
import app.studies.Listeners.InputListener;
import app.studies.view.Builders.InputForm;
import app.studies.view.components.ComboBoxBlock;
import app.studies.view.components.RadioInputBlock;
import app.studies.view.components.TextInputBlock;

import java.util.LinkedList;

public class CourseAdd extends InputForm {
    private String[] names;

    public CourseAdd(ChangeViewListener backTo, InputListener inputListener, String[] names) {
        super("Dodaj kurs", backTo, inputListener);
        this.names = names;
        init();
    }

    @Override
    protected void prepareData() {
        this.inputs = new LinkedList<>();
        inputs.add(new TextInputBlock("name", "Nazwa kursu: "));
        inputs.add(new TextInputBlock("ects", "ECTS: "));
        inputs.add(new TextInputBlock("hours", "Ilość godzin: "));
        inputs.add(new RadioInputBlock("type", "Forma: ", "Zaoczne", "Dzienne"));
        inputs.add(new ComboBoxBlock("leader", "Prowadzący: ", names));
    }

    public void setNames(String[] names) {
        this.names = names;
        removeAll();
        init();
        repaint();
    }
}
