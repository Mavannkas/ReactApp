package app.studies.view;

import app.studies.view.Builders.InputBlock;
import app.studies.view.Builders.InputForm;
import app.studies.view.Students.AddStudent;
import app.studies.view.Workers.WorkerAdd;
import app.studies.view.components.ComboBoxBlock;
import app.studies.view.components.RadioInputBlock;
import app.studies.view.components.TextInputBlock;
import app.studies.view.courses.AddStudentToCourse;
import app.studies.view.courses.CourseAdd;
import app.studies.view.courses.CursesList;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class Frame extends JFrame {
    public Frame() {
        super("Students App");
//
//        JPanel panel = new HelloPanel();
//        add(panel);

        setMinimumSize(new Dimension(600, 400));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void updatePanel(JPanel panel) {
        getContentPane().removeAll();
        revalidate();
        repaint();
        add(panel);
        validate();
    }
}
