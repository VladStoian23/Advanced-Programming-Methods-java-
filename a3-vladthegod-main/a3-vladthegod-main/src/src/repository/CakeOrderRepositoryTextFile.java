package repository;

import domain.CakeOrder;

import java.io.*;
import java.time.LocalDate;

public class CakeOrderRepositoryTextFile extends FileRepository<CakeOrder, Integer> {
    public CakeOrderRepositoryTextFile(String filename) {
        super(filename);
    }

    @Override
    protected void readFromFile() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                String[] stringOfData = line.split(",");
                if (stringOfData.length != 4) {
                    continue;
                } else {
                    int orderId = Integer.parseInt(stringOfData[0].trim());
                    String name = stringOfData[1].trim();
                    String location = stringOfData[2].trim();
                    LocalDate date = LocalDate.parse(stringOfData[3].trim());

                    CakeOrder cakeOrderRead = new CakeOrder(orderId, name, location, date.toString());

                    MemElements.put(orderId, cakeOrderRead);
                }
            }
        } catch (IOException e) {
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
