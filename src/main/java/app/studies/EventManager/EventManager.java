package app.studies.EventManager;

import app.studies.Students.Student;

import java.util.ArrayList;
import java.util.List;

public class EventManager {
    List<EventListener> listeners = new ArrayList<>();

    public EventManager() {
    }

    public void subscribe(EventListener listener) {
        listeners.add(listener);
    }

    public void unsubscribe( EventListener listener) {
        listeners.remove(listener);
    }

    public void notify(Object o) {
        for (EventListener listener : listeners) {
            listener.update(o);
        }
    }
}
