package repository;

import domain.CakeOrder;

import java.io.*;
import java.util.Map;

public class CakeOrderRepositoryBinaryFile extends FileRepository<CakeOrder, Integer> {
    public CakeOrderRepositoryBinaryFile(String filename) {
        super(filename);
    }

    @Override
    protected void readFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            this.MemElements = (Map<Integer, CakeOrder>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void writeFile() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
            Iterable<CakeOrder> listOfCakeOrders = getAllItems();
            for (CakeOrder cakeOrder : listOfCakeOrders) {
                bufferedWriter.write(cakeOrder.getId() + ", " +
                        cakeOrder.getName() + ", " +
                        cakeOrder.getLocation() + ", " +
                        cakeOrder.getDate());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
