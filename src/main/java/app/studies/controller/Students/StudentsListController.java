package app.studies.controller.Students;

import app.studies.Listeners.ChangeViewListener;
import app.studies.Listeners.CustomTableClickListener;
import app.studies.Students.Student;
import app.studies.controller.BasicController;
import app.studies.controller.RootControler;
import app.studies.view.Frame;
import app.studies.view.Students.StudentsList;
import app.studies.view.courses.CursesList;

import javax.swing.*;

public class StudentsListController implements BasicController {
    private CustomTableClickListener customTableClickListener;
    private RootControler rootControler;
    private Frame mainFrame;
    private final StudentsList studentsList;

    private final ChangeViewListener backTo;

    public StudentsListController(Frame mainFrame, RootControler rootControler, ChangeViewListener back, Student[] students) {
        this.rootControler = rootControler;
        this.mainFrame = mainFrame;

        this.customTableClickListener = new CustomTableClickListener(mainFrame, null, rootControler);

        this.studentsList = new StudentsList(back, customTableClickListener, students);
        backTo = new ChangeViewListener(mainFrame, studentsList);

    }

    public void update(Student[] students) {
        System.out.println("Aktualizacja" + students.length);
        studentsList.updateStudents(students);
    }

    @Override
    public JPanel getPanel() {
        return studentsList;
    }
}
