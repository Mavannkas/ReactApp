package app.studies.view.components;

import app.studies.view.Builders.InputBlock;

import javax.swing.*;
import java.awt.*;

public class TextInputBlock extends InputBlock {
    private JTextField textField;

    public TextInputBlock(String key, String label) {
        super(key, label);
        setMaximumSize(new Dimension(250, 25));
        createComponents();
    }

    @Override
    protected void createComponents() {
        textField = new JTextField();
        textField.setMaximumSize(new Dimension(150, 25));
        add(textField);
    }


    public String getValue() {
        return textField.getText();
    }

    @Override
    public void clear() {
        textField.setText("");
    }
}
