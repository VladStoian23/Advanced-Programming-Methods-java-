package repository;
import domain.BirthdayCake;
import domain.CakeOrder;
import exceptions.AlreadyExistentItem;
import exceptions.InexistentItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;
public class FileRepositoryTest {

    private FileRepository<BirthdayCake,Integer> birthdayCakeRepository;

    @BeforeEach
    void setUp() throws AlreadyExistentItem {
        birthdayCakeRepository = new BirthdayCakeRepositoryTextFile("BirthdayCake.txt");
        BirthdayCake cake1 = new BirthdayCake(1, "Chocolate Delight", "Chocolate");
        BirthdayCake cake2 = new BirthdayCake(2, "Vanilla Dream", "Vanilla");
        birthdayCakeRepository.addItem(cake1);
        birthdayCakeRepository.addItem(cake2);
    }

    @Test
    void readFromFile()
    {}

    @Test
    void writeFile(){}

    @Test
    void addItem() throws AlreadyExistentItem{
        BirthdayCake cake1 = new BirthdayCake(1, "Chocolate Delight", "Chocolate");
        BirthdayCake cake2 = new BirthdayCake(2, "Vanilla Dream", "Vanilla");
        birthdayCakeRepository.addItem(cake1);

        Iterable<BirthdayCake> listOfCakes= birthdayCakeRepository.getAllItems();

        boolean found =false;
        for(BirthdayCake cake:listOfCakes)
        {
            if(cake.getId()==1)
            {
                found=true;
                break;
            }

        } assertTrue(found);
        try{
            birthdayCakeRepository.addItem(cake2);
        }catch (AlreadyExistentItem e){
            System.out.println("Item already in");
        }
    }
    @Test
    void deleteItemById() throws AlreadyExistentItem {
            assert birthdayCakeRepository.MemElements.size()==2;
            BirthdayCake cake3 = new BirthdayCake(3, "Strawberry Bliss", "Strawberry");
            birthdayCakeRepository.addItem(cake3);
            try{
                birthdayCakeRepository.removeItem(32);
            } catch (InexistentItem e) {
                System.out.println("Not existent in here");
            }
        try{
            birthdayCakeRepository.removeItem(3);
        } catch (InexistentItem e) {
            System.out.println("Not existent in here");
        }
        //assertEquals(2, birthdayCakeRepository.MemElements.size(), "Size should remain unchanged");

    }

    @Test
    void getItemById() throws AlreadyExistentItem {
        BirthdayCake cake1 = new BirthdayCake(1, "Chocolate delight", "Chocolate");
        BirthdayCake cake2 = new BirthdayCake(2, "Vanilla dream", "Vanilla");

        try {
            birthdayCakeRepository.addItem(cake1);
        } catch (AlreadyExistentItem e) {
            System.out.println("Item already exists");
        }

        try {
            birthdayCakeRepository.addItem(cake2);
        } catch (AlreadyExistentItem e) {
            System.out.println("Item already exists");
        }
        Iterable<BirthdayCake> listOfBirthdayCakes= birthdayCakeRepository.getAllItems();
        boolean found=false;
        for(BirthdayCake cake:listOfBirthdayCakes)
        {
            if(cake.getId()==1)
                found=true;
        }
        assertTrue(found);

        try{
            birthdayCakeRepository.findItem(10);
        }catch(InexistentItem e)
        {
            System.out.println("Item not exisdtent");
        }
    }


    @Test
    void updateItemById() throws InexistentItem {
        BirthdayCake cakeToUpdate = new BirthdayCake(1, "New Name", "New Flavour");
        birthdayCakeRepository.updateItemById(1, cakeToUpdate);
        assertEquals("New Name",birthdayCakeRepository.findItem(1).getName());
    }

    @Test
    void getAllItems() throws InexistentItem {
        Iterable<BirthdayCake> listOfCakes = birthdayCakeRepository.getAllItems();
        int counter = 0;
        for (BirthdayCake cake : listOfCakes) {
            counter++;
        }
        System.out.println("Number of cakes: " + counter);
        assertEquals(2, counter);
    }


}
