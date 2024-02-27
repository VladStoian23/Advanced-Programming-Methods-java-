package repository;
import domain.BirthdayCake;
import exceptions.AlreadyExistentItem;
import exceptions.InexistentItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class MemoryRepositoryTest {
    private MemoryRepository<BirthdayCake, Integer> memoryRepository;

    @BeforeEach
    void setUp() throws AlreadyExistentItem{
        memoryRepository=new MemoryRepository<>();
        BirthdayCake cake1=new BirthdayCake(1,"Chocolate","Chocolate");
        BirthdayCake cake2=new BirthdayCake(2,"Vanilla","Vanilla");
        memoryRepository.addItem(cake1);
        memoryRepository.addItem(cake2);

    }
    @Test
    void addItem() {
        assert memoryRepository.MemElements.size() == 2;
        try {
            memoryRepository.addItem(new BirthdayCake(3, "Strawberry", "Strawberry"));
        } catch (AlreadyExistentItem e) {
            System.out.println("An item with id 3 already exists");
        }
        assert memoryRepository.MemElements.size() == 3;
    }
    @Test
    void findItem() {
        try {
            assertEquals("Chocolate", memoryRepository.findItem(1).getFlavour());
            assertNotEquals("Vanilla", memoryRepository.findItem(1).getFlavour());
            memoryRepository.findItem(10);
        } catch (InexistentItem e) {
            System.out.println("Item not found");
        }
    }

    @Test
    void updateItemById() {
        BirthdayCake newCake1 = new BirthdayCake(1, "Strawberry", "Strawberry");
        try {
            memoryRepository.updateItemById(1, newCake1);
            assertEquals("Strawberry", memoryRepository.findItem(1).getFlavour());
        } catch (InexistentItem e) {
            System.out.println("Item not found");
        }
        try {
            memoryRepository.updateItemById(10, newCake1);
        } catch (InexistentItem e) {
            System.out.println("Item not found");
        }
    }

    @Test
    void removeItem() {
        try {
            assertTrue(memoryRepository.removeItem(1));
            assertFalse(memoryRepository.removeItem(10));
        } catch (InexistentItem e) {
            System.out.println("Item not found");
        }
    }

    @Test
    void getAllItems() {
        Iterable<BirthdayCake> listOfCakes = memoryRepository.getAllItems();
        int counter = 0;
        for (BirthdayCake cake : listOfCakes) {
            counter++;
        }
        assertEquals(2, counter);
    }

}
