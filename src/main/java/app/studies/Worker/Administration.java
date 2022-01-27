package app.studies.Worker;

import app.studies.Person.Person;

import java.io.Serializable;

public class Administration extends Worker implements Serializable {
    private static final long serialVersionUID = 6L;
    private int languages;
    private String mode;

    public Administration(int ID, Person person, int hoursPerMonth, int salary, int languages, String mode) {
        super(ID, person, hoursPerMonth, salary, "Administracja");
        this.languages = languages;
        this.mode = mode;
    }

    public int getLanguages() {
        return languages;
    }

    public void setLanguages(int languages) {
        this.languages = languages;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
}
