package app.studies.view.Workers;

import app.studies.Listeners.ChangeViewListener;
import app.studies.Listeners.InputListener;
import app.studies.view.Builders.InputForm;
import app.studies.view.components.DetailsComponent;
import app.studies.view.components.RadioInputBlock;
import app.studies.view.components.TextInputBlock;

import java.util.LinkedList;

public class GetSalary extends InputForm implements DetailsComponent {
    private int ID;
    public GetSalary(ChangeViewListener backTo, InputListener inputListener) {
        super("Policz wypłatę", backTo, inputListener);
        init();
    }

    @Override
    protected void prepareData() {
        this.inputs = new LinkedList<>();
        inputs.add(new RadioInputBlock("type", "Rodzaj: ", "v1", "v2"));
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
