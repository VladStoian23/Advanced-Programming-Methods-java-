package repository;

import domain.BirthdayCake;

import java.io.*;
import java.util.Objects;

public class BirthdayCakeRepositoryTextFile extends FileRepository<BirthdayCake,Integer> {
    public BirthdayCakeRepositoryTextFile(String filename) {
        super(filename);
    }

    @Override
    protected void readFromFile() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                String[] stringOfData = line.split(",");
                if (stringOfData.length != 3) {
                    continue;
                } else {
                    int cakeId = Integer.parseInt(stringOfData[0].trim());
                    String cakeName = stringOfData[1].trim();
                    String cakeFlavour = stringOfData[2].trim();

                    BirthdayCake cakeRead = new BirthdayCake(cakeId, cakeName, cakeFlavour);

                    MemElements.put(cakeId, cakeRead);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void writeFile() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
            Iterable<BirthdayCake> listOfCakes = getAllItems();
            for (BirthdayCake cake : listOfCakes) {
                bufferedWriter.write(cake.getId() + ", " +
                        cake.getName() + ", " +
                        cake.getFlavour());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
