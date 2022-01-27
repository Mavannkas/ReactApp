package app.studies.view.Builders;

import app.studies.Listeners.ChangeViewListener;
import app.studies.Worker.Worker;
import app.studies.view.customCells.DeleteButtonRenderer;
import app.studies.view.customCells.ShowInfoRenderer;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class EntityList extends JPanel {
    private JButton goBackButton;
    private ChangeViewListener goBackListener;

    protected List<List<String>> rows;
    private ArrayList<String> headers;
    protected JTable table;
    protected String[][] rowsData;
    protected String[] headersData;

    public EntityList(ChangeViewListener goBackListener) {
        super();
        this.goBackListener = goBackListener;
        setLayout(new BorderLayout());

    }

    public void clearTable() {
        removeAll();
    }

    protected void init() {
        initData();
        initPanel();
        initCustomCells();
        addComponents();
        revalidate();
    }

    protected void initData() {
        prepareData();
        fillData();
        addDefaultData();
    }

    protected abstract void prepareData();

    private void fillData() {
        rows = new ArrayList<>();

        for (String[] strings : rowsData) {
            ArrayList<String> row = new ArrayList<>(Arrays.asList(strings));
            rows.add(row);
        }

        headers = new ArrayList<>();

        headers.addAll(Arrays.asList(headersData));
    }

    private void addDefaultData() {
        headers.add("");
        headers.add("");

        for(List<String> row : rows) {
            row.addAll(Arrays.asList("Szczegóły", "Usuń"));
        }
    }

    private void initPanel() {
        String[][] rowsData = castDataTo2DArray();

        table = new JTable(rowsData, castListToArray(headers));

        table.setRowSelectionAllowed(false);

        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.setDefaultEditor(Object.class, null);


        goBackButton = new JButton("<- Cofnij");
        goBackButton.addActionListener(goBackListener);
    }

    private String[][] castDataTo2DArray() {
        int rows = this.rows.size();

        if(rows == 0) {
            return new String[0][0];
        }

        int columns = this.rows.get(0).size();
        String[][] rowsData = new String[rows][columns];

        for(int i = 0; i < rows; i++) {
            rowsData[i] = castListToArray(this.rows.get(i));
        }

        return rowsData;
    }

    private String[] castListToArray(List<String> list) {
        return list.toArray(new String[0]);
    };

    protected void initCustomCells() {
        addCustomCellsStyle();
        addCustomCellsBehavior();
    }

    private void addCustomCellsStyle() {
        int rowSize = headers.size();
        table.getColumnModel().getColumn(rowSize - 2).setCellRenderer(new ShowInfoRenderer());
        table.getColumnModel().getColumn(rowSize - 1).setCellRenderer(new DeleteButtonRenderer());
    }

    protected abstract void addCustomCellsBehavior();

    private void addComponents() {
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
        add(goBackButton, BorderLayout.SOUTH);
    }

}