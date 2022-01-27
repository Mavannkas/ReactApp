package app.studies.Listeners;


import app.studies.view.Frame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeViewListener implements ActionListener {
    private final Frame frame;
    private JPanel panel;

    public ChangeViewListener(Frame frame, JPanel panel) {
        this.frame = frame;
        this.panel = panel;

    }

    public void changePanel(JPanel panel) {
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        frame.updatePanel(panel);
    }
}
