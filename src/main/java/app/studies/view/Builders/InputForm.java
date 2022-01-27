package app.studies.view.Builders;

import app.studies.Listeners.ChangeViewListener;
import app.studies.Listeners.InputListener;
import app.studies.view.components.InputComponent;
import app.studies.view.components.TextInputBlock;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class InputForm extends JPanel {
    protected final String title;
    protected List<InputBlock> inputs;
    private JButton goBackButton;
    private JButton submitButton;
    private ChangeViewListener backTo;
    private InputListener inputListener;

    public InputForm(String title, ChangeViewListener backTo, InputListener inputListener) {
        super();
        this.title = title;
        this.backTo = backTo;
        this.inputListener = inputListener;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

    }

    protected void init() {
        prepareData();
        createBasicComponents(title);
    }

    protected abstract void prepareData();


    protected void createBasicComponents(String sectionTitle) {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(sectionTitle);
        title.setFont(new Font("Arial", Font.BOLD, 28));
        JPanel titlePanel = new JPanel();
        titlePanel.add(title);
        titlePanel.setMaximumSize(new Dimension(500, 100));
        mainPanel.add(titlePanel);

        for (JPanel inputComponent : inputs) {
            mainPanel.add(inputComponent);
            mainPanel.add(Box.createRigidArea(new Dimension(5, 10)));
        }

        goBackButton = new JButton("<- Cofnij");
        goBackButton.addActionListener(backTo);
        submitButton = new JButton("Zatwierdź");

        if(inputListener != null) {
            inputListener.changePanel(this);
            submitButton.addActionListener(inputListener);
        }

        JPanel allButtons = new JPanel();
        allButtons.setLayout(new BoxLayout(allButtons, BoxLayout.X_AXIS));
        allButtons.add(submitButton);
        allButtons.add(Box.createRigidArea(new Dimension(10, 0)));
        allButtons.add(goBackButton);


        mainPanel.add(allButtons);
        JScrollPane scrollPane = new JScrollPane(mainPanel);

        add(scrollPane);
    }

    public Map<String, String> getValues() {
        Map<String, String> output = new HashMap<>();

        for (InputBlock input : inputs) {
            output.put(input.getKey(), input.getValue());
        }

        return output;
    }

    public void clear() {
        for (InputBlock input : inputs) {
            input.clear();
        }
    }

}
