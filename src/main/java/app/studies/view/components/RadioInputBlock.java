package app.studies.view.components;

import app.studies.view.Builders.InputBlock;

import javax.swing.*;
import java.awt.*;
import java.util.Enumeration;

public class RadioInputBlock extends InputBlock {
    private JRadioButton firstRadio;
    private JRadioButton secondRadio;
    private ButtonGroup buttonGroup;

    private String firstString;
    private String secondString;

    public RadioInputBlock(String key, String label, String firstString, String secondString) {
        super(key, label);
        this.firstString = firstString;
        this.secondString = secondString;
        createComponents();
    }

    @Override
    protected void createComponents() {

        firstRadio = new JRadioButton(firstString);
        firstRadio.setActionCommand(firstString);

        secondRadio = new JRadioButton(secondString);
        firstRadio.setActionCommand(secondString);

        buttonGroup = new ButtonGroup();

        buttonGroup.add(firstRadio);
        buttonGroup.add(secondRadio);
        firstRadio.setSelected(true);
        secondRadio.setSelected(false);

        add(firstRadio);
        add(secondRadio);
    }


    public String getValue() {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }

        return null;
    }

    @Override
    public void clear() {
        firstRadio.setSelected(true);
        secondRadio.setSelected(true);

    }
}
