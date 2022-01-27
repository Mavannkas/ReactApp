package app.studies.SalaryStrategies;

import app.studies.Worker.Worker;
import app.studies.services.WorkerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UniversalSalaryCounterTest {

    private Worker worker;
    private UniversalSalaryCounter universalSalaryCounter;

    @BeforeEach
    void initService() {
        this.universalSalaryCounter = new UniversalSalaryCounter();
        this.worker = new WorkerService().getWorkersArray()[0];
    }

    @Test
    void getSalary() {
       int salary = universalSalaryCounter.getSalary(worker);
       assertTrue(salary > 0);
    }
}