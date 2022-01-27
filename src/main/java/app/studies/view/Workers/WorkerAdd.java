package app.studies.view.Workers;

import app.studies.Listeners.ChangeViewListener;
import app.studies.Listeners.InputListener;
import app.studies.view.Builders.InputForm;
import app.studies.view.components.RadioInputBlock;
import app.studies.view.components.TextInputBlock;

import java.util.LinkedList;

public class WorkerAdd extends InputForm {
    public WorkerAdd(ChangeViewListener backTo, InputListener inputListener) {
        super("Dodaj pracownika", backTo, inputListener);
        init();
    }

    @Override
    protected void prepareData() {
        this.inputs = new LinkedList<>();
        inputs.add(new TextInputBlock("name", "Imie: "));
        inputs.add(new TextInputBlock("surname", "Nazwisko: "));
        inputs.add(new TextInputBlock("birth", "Rok urodzenia: "));
        inputs.add(new TextInputBlock("hours", "Wymiar pracy: "));
        inputs.add(new TextInputBlock("salary", "Wypłata: "));
        inputs.add(new RadioInputBlock("type", "Typ: ", "N/D", "Administacja"));
        inputs.add(new TextInputBlock("cursesCount", "Liczba kursów: "));
        inputs.add(new TextInputBlock("publicCount", "Liczba publikacji: "));
        inputs.add(new RadioInputBlock("shift", "Tryb: ", "Dzien", "Noc"));
        inputs.add(new TextInputBlock("languages", "Ilość języków: "));
    }
}
