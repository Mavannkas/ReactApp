package app.studies.view.Students;

import app.studies.Listeners.ChangeViewListener;
import app.studies.Listeners.InputListener;
import app.studies.view.Builders.InputForm;
import app.studies.view.components.TextInputBlock;

import java.util.LinkedList;

public class AddStudent extends InputForm {
    public AddStudent(ChangeViewListener backTo, InputListener inputListener) {
        super("Dodaj studenta", backTo, inputListener);
        init();
    }

    @Override
    protected void prepareData() {
        this.inputs = new LinkedList<>();
        inputs.add(new TextInputBlock("name", "Imie: "));
        inputs.add(new TextInputBlock("surname", "Nazwisko: "));
        inputs.add(new TextInputBlock("birth", "Rok urodzenia: "));
        inputs.add(new TextInputBlock("year", "Rocznik: "));
    }
}
