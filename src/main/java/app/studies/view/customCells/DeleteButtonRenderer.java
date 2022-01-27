package app.studies.view.customCells;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class DeleteButtonRenderer extends DefaultTableCellRenderer {
    public DeleteButtonRenderer() {
        setBackground(Color.RED);
        setForeground(Color.white);
        setHorizontalAlignment(JLabel.CENTER);
        setFont(new Font("Arial", Font.BOLD, 14));
    }
}
