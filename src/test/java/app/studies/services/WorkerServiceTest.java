package app.studies.services;

import app.studies.Person.Person;
import app.studies.Worker.DidacticWorker;
import app.studies.Worker.Worker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorkerServiceTest {

    private WorkerService workerService;

    @BeforeEach
    void initService() {
        this.workerService = new WorkerService();
    }


    @Test
    void addAdministration() {
        int prevLength = workerService.getWorkersArray().length;

        workerService.addDidacticWorker(
                "Adam",
                "Balaszyk",
                12,
                100,
                3000,
                12,
                10
        );

        assertEquals(prevLength + 1, workerService.getWorkersArray().length);
    }

    @Test
    void checkIsSaved() {
        int prevLength = workerService.getWorkersArray().length;

        this.workerService.addDidacticWorker(
                "Adam",
                "Balaszyk",
                12,
                100,
                3000,
                12,
                10
        );

        WorkerService workerService = new WorkerService();

        assertEquals(prevLength + 1, workerService.getWorkersArray().length);

        this.workerService.deleteWorker(this.workerService.getWorkersArray()[prevLength].getID());
    }

    @Test
    void deleteWorker() {
        int prevLength = workerService.getWorkersArray().length;

        workerService.deleteWorker(workerService.getWorkersArray()[prevLength - 1].getID());

        assertEquals(prevLength - 1, workerService.getWorkersArray().length);

    }

    @Test
    void getWorkersArray() {
        assertNotNull(workerService.getWorkersArray());
    }
}