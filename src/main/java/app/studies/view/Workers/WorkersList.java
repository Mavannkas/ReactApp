package app.studies.view.Workers;

import app.studies.Listeners.ChangeViewListener;
import app.studies.Listeners.CustomTableClickListener;
import app.studies.Worker.Administration;
import app.studies.Worker.DidacticWorker;
import app.studies.Worker.Worker;
import app.studies.view.Builders.EntityList;


public class WorkersList extends EntityList {
    private Worker[] workers;
    private CustomTableClickListener customTableClickListener;

    public WorkersList(ChangeViewListener goBack, CustomTableClickListener customTableClickListener, Worker[] workers) {
        super(goBack);
        this.customTableClickListener = customTableClickListener;
        this.workers = workers;
        init();
    }

    @Override
    protected void prepareData() {
        rowsData =  mapWorkersToStringArrays();;

        headersData = new String[] {
                "ID",
                "Imie",
                "Nazwisko",
                "Rok urodzenia",
                "Wymiar pracy",
                "Wyplata",
                "Typ",
                "Liczba prowadzonych kursów",
                "Publikacje",
                "Tryb pracy",
                "Języki"
        };
    }


    private String[][] mapWorkersToStringArrays() {
        String[][] output= new String[workers.length][6];
        for(int i = 0; i < output.length; i++) {
            if(workers[i] instanceof DidacticWorker) {
                output[i] = mapDidacticWorkerToStringArray((DidacticWorker) workers[i]);
            } else {
                output[i] = mapAdministrationWorkerToStringArray((Administration) workers[i]);
            }
        }
        return output;
    }

    private String[] standardMap(Worker worker) {
        String[] output = new String[11];
        output[0] = Integer.toString(worker.getID());
        output[1] = worker.getPerson().getName();
        output[2] = worker.getPerson().getSurname();
        output[3] = Integer.toString(worker.getPerson().getBirthYear());
        output[4] = Integer.toString(worker.getHoursPerMonth());
        output[5] = Integer.toString(worker.getSalary());
        output[6] = worker.getType();
        return output;
    }

    private String[] mapDidacticWorkerToStringArray(DidacticWorker worker) {
        String[] output = standardMap(worker);

        output[7] = Integer.toString(worker.getCoursesCount());
        output[8] = Integer.toString(worker.getPublications());
        output[9] = "";
        output[10] = "";

        return output;
    }

    private String[] mapAdministrationWorkerToStringArray(Administration worker) {
        String[] output = standardMap(worker);

        output[7] = "";
        output[8] = "";
        output[9] = worker.getMode();
        output[10] = Integer.toString(worker.getLanguages());

        return output;
    }

    public void updateWorkers(Worker[] workers) {
        this.workers = workers;
        rowsData =  mapWorkersToStringArrays();
        clearTable();
        init();
    }

    @Override
    protected void addCustomCellsBehavior() {
        customTableClickListener.addTable(table);
        table.addMouseListener(customTableClickListener);
    }

}