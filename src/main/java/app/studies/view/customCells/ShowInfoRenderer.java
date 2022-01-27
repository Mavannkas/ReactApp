package app.studies.view.customCells;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class ShowInfoRenderer extends DefaultTableCellRenderer {
    public ShowInfoRenderer() {
        setBackground(new Color(55, 183, 229));
        setForeground(Color.white);
        setHorizontalAlignment(JLabel.CENTER);
        setFont(new Font("Arial", Font.BOLD, 14));
    }
}
