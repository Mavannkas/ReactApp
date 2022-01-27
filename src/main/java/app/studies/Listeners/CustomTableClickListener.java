package app.studies.Listeners;

import app.studies.controller.RootControler;
import app.studies.view.Frame;
import app.studies.view.components.DetailsComponent;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CustomTableClickListener extends MouseAdapter {
    private JTable table;
    private RootControler rootControler;
    private final Frame frame;
    private DetailsComponent panel;

    public CustomTableClickListener(Frame frame, DetailsComponent panel, RootControler rootControler) {
        this.rootControler = rootControler;
        this.frame = frame;
        this.panel = panel;
    }

    public void mouseClicked(MouseEvent e)
    {
        int row = table.rowAtPoint(e.getPoint());
        int col = table.columnAtPoint(e.getPoint());
        int count = table.getColumnCount();
        int id = Integer.parseInt((String) table.getValueAt(row, 0));
        if (count - 1 == col) {
            rootControler.delete(id);
        }

        if (count - 2 == col) {
            if(panel != null) {
                panel.setID(id);
                frame.updatePanel((JPanel) panel);
            }
        }
    }

    public void addTable(JTable table) {
        this.table = table;
    }
}
