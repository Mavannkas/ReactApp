package app.studies.view.Builders;

import app.studies.Listeners.ChangeViewListener;

import javax.swing.*;
import java.awt.*;

public abstract class PanelBag extends JPanel {
    protected JPanel parent;
    protected JButton leftButton;
    protected JButton rightButton;
    protected JButton goBackButton;
    private ChangeViewListener goBackListener;

    public PanelBag(ChangeViewListener goBackListener) {
        super();
        this.goBackListener = goBackListener;

        GridBagLayout gridBag = new GridBagLayout();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        gridBagConstraints.fill = GridBagConstraints.CENTER;
        gridBag.setConstraints(this, gridBagConstraints);
        setLayout(gridBag); //doczytać o gridbag
        createComponents();
    }

    protected abstract void createComponents();

    protected void createBasicComponents(String sectionTitle){
        JLabel title = new JLabel(sectionTitle, SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 14));
        title.setVerticalAlignment(SwingConstants.TOP);
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BorderLayout());
        titlePanel.add(title, BorderLayout.NORTH);
        titlePanel.setSize(new Dimension(200, 200));

        parent = new JPanel();
        parent.setLayout(new GridLayout(2, 0));
        parent.add(titlePanel);


        this.add(parent);
    }

    protected void addThreeButtons() {
        goBackButton = new JButton("<- Cofnij");
        goBackButton.addActionListener(goBackListener);

        JPanel operateButtons = new JPanel();
        operateButtons.setLayout(new GridLayout(1, 2));
        operateButtons.add(leftButton);
        operateButtons.add(rightButton);

        JPanel allButtons = new JPanel();
        allButtons.setLayout(new GridLayout(2, 1));
        allButtons.add(operateButtons);
        allButtons.add(goBackButton);

        parent.add(allButtons);
    }

    public void addGoToListeners(ChangeViewListener goToAddWorker, ChangeViewListener goToWorkerList) {
        leftButton.addActionListener(goToAddWorker);
        rightButton.addActionListener(goToWorkerList);
    }
}
