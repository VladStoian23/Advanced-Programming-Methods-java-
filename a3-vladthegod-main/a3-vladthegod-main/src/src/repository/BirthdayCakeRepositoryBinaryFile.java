package repository;

import domain.BirthdayCake;

import java.io.*;
import java.util.Map;

public class BirthdayCakeRepositoryBinaryFile extends FileRepository<BirthdayCake, Integer> {
    public BirthdayCakeRepositoryBinaryFile(String filename) {
        super(filename);
    }

    @Override
    protected void readFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            this.MemElements = (Map<Integer, BirthdayCake>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void writeFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(this.MemElements);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
