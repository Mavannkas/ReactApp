package app.studies.view.courses;

import app.studies.Listeners.ChangeViewListener;
import app.studies.Listeners.InputListener;
import app.studies.view.Builders.InputForm;
import app.studies.view.components.ComboBoxBlock;
import app.studies.view.components.DetailsComponent;
import app.studies.view.components.RadioInputBlock;
import app.studies.view.components.TextInputBlock;

import java.util.LinkedList;

public class AddStudentToCourse extends InputForm implements DetailsComponent {
    private int ID;
    private String[] names;

    public AddStudentToCourse(ChangeViewListener backTo, InputListener inputListener, String[] names) {
        super("Dodaj kurs do studenta", backTo, inputListener);
        this.names = names;
        init();
    }

    @Override
    protected void prepareData() {
        this.inputs = new LinkedList<>();
        inputs.add(new ComboBoxBlock("students", "Studenci: ", names));
        inputs.add(new TextInputBlock("mark", "Ocena: "));
    }

    public void setNames(String[] names) {
        this.names = names;
        removeAll();
        init();
        repaint();
    }

    @Override
    public void setID(int ID) {
        this.ID = ID;
        removeAll();
        createBasicComponents(title + " dla ID=" + ID );
        repaint();
    }

    @Override
    public int getID() {
        return ID;
    }
}
