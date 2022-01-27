package app.studies.view.Builders;

import app.studies.view.components.InputComponent;

import javax.swing.*;
import java.awt.*;

public abstract class InputBlock extends JPanel implements InputComponent {
    private String key;
    private String labelString;
    private JLabel label;
    public InputBlock(String key, String label) {
        super();
        this.key = key;
        this.labelString = label;
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        createBasicComponents();
    }


    private void createBasicComponents() {
        label = new JLabel(labelString);
        add(label);
    }

    public String getKey() {
        return key;
    }


    protected abstract void createComponents();
}
