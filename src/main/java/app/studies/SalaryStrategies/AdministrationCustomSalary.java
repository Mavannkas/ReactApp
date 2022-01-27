package app.studies.SalaryStrategies;

import app.studies.Worker.Administration;
import app.studies.Worker.Worker;

import java.util.Objects;

public class AdministrationCustomSalary implements SalaryStrategy {
    @Override
    public int getSalary(Worker worker) {
        Administration administration = (Administration) worker;
        int salary = (int) (administration.getSalary() * (administration.getHoursPerMonth() / 180.0) * (((administration.getLanguages() + 10) / 100.0 ) + 1));
        return Objects.equals(administration.getMode(), "Noc") ? salary + 1000 : salary;
    }
}
