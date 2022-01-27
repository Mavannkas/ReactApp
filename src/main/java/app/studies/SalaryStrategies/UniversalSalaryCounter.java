package app.studies.SalaryStrategies;

import app.studies.Worker.Worker;

public class UniversalSalaryCounter implements SalaryStrategy{
    @Override
    public int getSalary(Worker worker) {
        return (int) (worker.getSalary() * (worker.getHoursPerMonth() / 180.0));
    }
}
