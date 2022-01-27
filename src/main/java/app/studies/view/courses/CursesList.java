package app.studies.view.courses;

import app.studies.Courses.Course;
import app.studies.Listeners.ChangeViewListener;
import app.studies.Listeners.CustomTableClickListener;
import app.studies.Students.Student;
import app.studies.view.Builders.EntityList;


public class CursesList extends EntityList {
    private Course[] courses;
    private CustomTableClickListener customTableClickListener;

    public CursesList(ChangeViewListener goBack, CustomTableClickListener customTableClickListener, Course[] courses) {
        super(goBack);
        this.customTableClickListener = customTableClickListener;
        this.courses = courses;
        init();
    }

    @Override
    protected void prepareData() {
        rowsData = mapCoursesToStringArrays();

        headersData = new String[] {
                "ID",
                "Nazwa kursu",
                "ECTS",
                "Ilość godzin",
                "Forma",
                "Prowadzący",
                "Ilość uczniów"
        };
    }


    public void updateStudents(Course[] courses) {
        this.courses = courses;
        rowsData =  mapCoursesToStringArrays();
        clearTable();
        init();
    }

    private String[][] mapCoursesToStringArrays() {
        String[][] output= new String[courses.length][6];
        for(int i = 0; i < output.length; i++) {
            output[i] = mapCourseToStringArray(courses[i]);
        }
        return output;
    }

    private String[] mapCourseToStringArray(Course course) {
        String[] output = new String[7];
        output[0] = Integer.toString(course.getID());
        output[1] = course.getName();
        output[2] = Integer.toString(course.getECTS());
        output[3] = Integer.toString(course.getHours());
        output[4] = course.getType();
        output[5] = course.getLeader();
        output[6] = String.valueOf(course.getCourseResults().size());

        return output;
    }

    @Override
    protected void addCustomCellsBehavior() {
        customTableClickListener.addTable(table);
        table.addMouseListener(customTableClickListener);

    }

}
