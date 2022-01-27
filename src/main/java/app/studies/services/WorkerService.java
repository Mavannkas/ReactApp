package app.studies.services;

import app.studies.Person.Person;
import app.studies.Worker.Administration;
import app.studies.Worker.DidacticWorker;
import app.studies.Worker.Worker;

import java.io.IOException;
import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

public class WorkerService extends BasicService<Set<Worker>> {
    private final String PATH = "./workers.db";
    private final Set<Worker> workers = new TreeSet<>();

    public WorkerService() {
        try {
            readObjects();
        } catch (IOException | ClassNotFoundException err) {
            System.out.println(err.getMessage());
        }
    }

    public void addDidacticWorker(String name, String surname, int birthYear, int hoursPerMonth, int salary, int coursesCount, int publications) {
        Person person = new Person(name, surname, birthYear);
        Worker worker = new DidacticWorker(getLastWorkerID() + 1, person, hoursPerMonth, salary, coursesCount, publications);
        workers.add(worker);
        saveObjects();
    }
    public void addAdministration(String name, String surname, int birthYear, int hoursPerMonth, int salary, int languages, String mode) {
        Person person = new Person(name, surname, birthYear);
        Worker worker = new Administration(getLastWorkerID() + 1, person, hoursPerMonth, salary, languages, mode);
        workers.add(worker);
        saveObjects();
    }

    public void deleteWorker(int id) {
        for(Worker worker : workers) {
            if(worker.getID() == id) {
                workers.remove(worker);
                break;
            }
        }
        saveObjects();
    }

    private int getLastWorkerID() {
        Worker lastWorker = null;
        for(Worker worker : workers) {
            lastWorker = worker;
        }
        return lastWorker != null ? lastWorker.getID() : -1;
    }

    @Override
    public void readObjects() throws IOException, ClassNotFoundException {
        Collection<Worker> workers = readFile(PATH);
        if(workers != null) {
            this.workers.addAll(workers);
        }
    }

    @Override
    public void saveObjects() {
        try {
        writeToFile(workers, PATH);
        } catch (IOException err) {}
    }

    public Worker[] getWorkersArray() {
        return workers.toArray(new Worker[0]);
    }

}
