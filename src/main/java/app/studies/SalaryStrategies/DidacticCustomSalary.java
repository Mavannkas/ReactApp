package app.studies.SalaryStrategies;

import app.studies.Worker.DidacticWorker;
import app.studies.Worker.Worker;

public class DidacticCustomSalary implements SalaryStrategy {
    @Override
    public int getSalary(Worker worker) {
        DidacticWorker didacticWorker = (DidacticWorker) worker;
        return (int) (didacticWorker.getSalary() * (didacticWorker.getHoursPerMonth() / 180.0) * (((didacticWorker.getPublications()) / 100.0 ) + 1) * (((didacticWorker.getCoursesCount()) / 100.0 ) + 1));
    }
}
