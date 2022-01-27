package app.studies.view.Students;

import app.studies.Listeners.ChangeViewListener;
import app.studies.Students.Student;
import app.studies.view.Builders.EntityList;
import app.studies.Listeners.CustomTableClickListener;


public class StudentsList extends EntityList {
    private Student[] students;
    private CustomTableClickListener customTableClickListener;
    public StudentsList(ChangeViewListener goBack, CustomTableClickListener customTableClickListener,Student[] students) {
        super(goBack);
        this.customTableClickListener = customTableClickListener;
        this.students = students;
        init();
    }

    @Override
    protected void prepareData() {
        rowsData =  mapStudentsToStringArrays();

        headersData = new String[] {"ID", "Imie", "Nazwisko", "Rok urodzenia", "Rocznik", "Info"};
    }

    public void updateStudents(Student[] students) {
        this.students = students;
        rowsData =  mapStudentsToStringArrays();
        clearTable();
        init();
    }

    private String[][] mapStudentsToStringArrays() {
        String[][] output= new String[students.length][6];
        for(int i = 0; i < output.length; i++) {
            output[i] = mapStudentToStringArray(students[i]);
        }
        return output;
    }

    private String[] mapStudentToStringArray(Student student) {
        String[] output = new String[6];
        output[0] = Integer.toString(student.getID());
        output[1] = student.getPerson().getName();
        output[2] = student.getPerson().getSurname();
        output[3] = Integer.toString(student.getPerson().getBirthYear());
        output[4] = student.getYear();
        output[5] = student.getAdditionalInfo();

        return output;
    }

    @Override
    protected void addCustomCellsBehavior() {
        customTableClickListener.addTable(table);
        table.addMouseListener(customTableClickListener);

    }
}
