package app.studies.services;

import app.studies.Students.Student;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;

public abstract class BasicService<T> {
    public abstract void readObjects() throws IOException, ClassNotFoundException;
    public abstract void saveObjects() throws IOException;

    public T readFile(String path) throws IOException, ClassNotFoundException {
        if(Files.exists(Paths.get(path))) {
            FileInputStream fin = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fin);
            Object saved= ois.readObject();

            fin.close();
            ois.close();

            return (T) saved;
        }
        return null;
    }

    public void writeToFile(T data, String path) throws IOException {
        FileOutputStream fout = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(fout);
        oos.writeObject(data);
        fout.close();
        oos.close();
    }
}
