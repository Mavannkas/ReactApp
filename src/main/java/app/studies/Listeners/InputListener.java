package app.studies.Listeners;


import app.studies.controller.RootControler;
import app.studies.view.Builders.InputForm;
import app.studies.view.Frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class InputListener implements ActionListener {
    private final Frame frame;
    private InputForm panel;
    private RootControler parent;

    public InputListener(Frame frame, RootControler parent) {
        this.frame = frame;
        this.parent = parent;
    }

    public void changePanel(InputForm panel) {
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Map<String, String> map = panel.getValues();

        parent.process(map);
        panel.clear();
    }
}
