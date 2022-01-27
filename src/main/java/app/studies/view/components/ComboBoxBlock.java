package app.studies.view.components;

import app.studies.view.Builders.InputBlock;

import javax.swing.*;
import java.awt.*;

public class ComboBoxBlock extends InputBlock {
    private JComboBox<String> box;
    private final String[] data;

    public ComboBoxBlock(String key, String label, String[] data) {
        super(key, label);
        this.data = data;
        setMaximumSize(new Dimension(250, 25));
        createComponents();
    }

    @Override
    protected void createComponents() {
        box = new JComboBox<>(data);
        box.setMaximumSize(new Dimension(150, 25));
        add(box);
    }


    public String getValue() {
        return String.valueOf(box.getSelectedItem());
    }

    @Override
    public void clear() {
        box.setSelectedIndex(0);
    }
}
