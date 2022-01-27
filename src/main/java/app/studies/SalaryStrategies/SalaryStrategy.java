package app.studies.SalaryStrategies;

import app.studies.Worker.Worker;

public interface SalaryStrategy {
    int getSalary(Worker worker);
}
