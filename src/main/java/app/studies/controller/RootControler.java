package app.studies.controller;

import java.util.Map;

public interface RootControler {
    void delete(int ID);
    void process(Map<String, String> map);
    void details(int ID);
}
