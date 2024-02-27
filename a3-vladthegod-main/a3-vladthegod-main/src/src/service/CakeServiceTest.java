package service;

import domain.BirthdayCake;
import domain.CakeOrder;
import exceptions.AlreadyExistentItem;
import exceptions.InexistentItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.BirthdayCakeRepository;
import repository.CakeOrderRepository;

import static org.junit.Assert.*;

public class CakeServiceTest {

    private CakeService testService;

    @BeforeEach
    void setUp(){
        BirthdayCakeRepository simulationBirthdayCakeRepository=new BirthdayCakeRepository();
        CakeOrderRepository simulationCakeOrderRepository=new CakeOrderRepository();

        testService=new CakeService<>(simulationBirthdayCakeRepository,simulationCakeOrderRepository);
    }

    @Test
    void addBirthdayCake () throws AlreadyExistentItem{
        System.out.println("Starting addBirthdayCake test");

        testService.addBirthdayCake(1, "ChocolateCake", "Chocolate");
        assert testService.birthdayCakeRepository.MemElements.size() == 1;

        assertThrows(AlreadyExistentItem.class, () -> testService.addBirthdayCake(1, "VanillaCake", "Vanilla"));

        System.out.println("Test completed successfully");

    }
    @Test
    void getBirthdayCakeByID() throws InexistentItem, AlreadyExistentItem {
        assertThrows(InexistentItem.class, () -> testService.getBirthdayCakeByID(1));

        testService.addBirthdayCake(1, "ChocolateCake", "Chocolate");
        assertNotNull(testService.getBirthdayCakeByID(1));
    }

    @Test
    void getAllBirthdayCake() throws InexistentItem, AlreadyExistentItem {
        assertNotNull(testService.getAllBirthdayCakes());

        testService.addBirthdayCake(1,"ChocolateCake","Chocolate");
        assertEquals(1, ((Iterable<BirthdayCake>) testService.getAllBirthdayCakes()).spliterator().getExactSizeIfKnown());

    }

    @Test
    void updateBirthdayCake() throws InexistentItem, AlreadyExistentItem {
        assertThrows(InexistentItem.class, () -> testService.updateBirthdayCake(1, "VanillaCake", "Vanilla"));

        testService.addBirthdayCake(1, "ChocolateCake", "Chocolate");
        testService.updateBirthdayCake(1, "VanillaCake", "Vanilla");

        assertEquals("VanillaCake", testService.getBirthdayCakeByID(1).getName());
        assertEquals("Vanilla", testService.getBirthdayCakeByID(1).getFlavour());
    }

    @Test
    void deleteBirthdayCakeByID() throws InexistentItem, AlreadyExistentItem {
        testService.addBirthdayCake(1, "ChocolateCake", "Chocolate");
        assert testService.birthdayCakeRepository.MemElements.size() == 1;

        testService.deleteBirthdayCakeByID(1);
        assert testService.birthdayCakeRepository.MemElements.isEmpty();
    }

    @Test
    void addCakeOrder() throws AlreadyExistentItem {
        testService.addCakeOrder(1, "Birthday Party", "City", "2023-12-31");
        assert testService.cakeOrderRepository.MemElements.size() == 1;

        assertThrows(AlreadyExistentItem.class, () -> testService.addCakeOrder(1, "Wedding", "Beach", "2024-01-01"));
    }

    @Test
    void getCakeOrderByID() throws InexistentItem, AlreadyExistentItem {
        assertThrows(InexistentItem.class, () -> testService.getCakeOrderByID(1));

        testService.addCakeOrder(1, "Birthday Party", "City", "2023-12-31");
        assertNotNull(testService.getCakeOrderByID(1));
    }
    @Test
    void getAllCakeOrders() throws AlreadyExistentItem {
        assertNotNull(testService.getAllCakeOrders());
        assertEquals(0, ((Iterable<CakeOrder>) testService.getAllCakeOrders()).spliterator().getExactSizeIfKnown());

        testService.addCakeOrder(1, "Birthday Party", "City", "2023-12-31");
        assertEquals(1, ((Iterable<CakeOrder>) testService.getAllCakeOrders()).spliterator().getExactSizeIfKnown());
    }
    @Test
    void updateCakeOrder() throws InexistentItem, AlreadyExistentItem {
        assertThrows(InexistentItem.class, () -> testService.updateCakeOrder(1, "Wedding", "Beach", "2024-01-01"));

        testService.addCakeOrder(1, "Birthday Party", "City", "2023-12-31");
        testService.updateCakeOrder(1, "Wedding", "Beach", "2024-01-01");

        assertEquals("Wedding", testService.getCakeOrderByID(1).getName());
        assertEquals("Beach", testService.getCakeOrderByID(1).getLocation());
        assertEquals("2024-01-01", testService.getCakeOrderByID(1).getDate());
    }

    @Test
    void deleteCakeOrderByID() throws InexistentItem, AlreadyExistentItem {
        assertThrows(InexistentItem.class, () -> testService.deleteCakeOrderByID(1));

        testService.addCakeOrder(1, "Birthday Party", "City", "2023-12-31");
        assert testService.cakeOrderRepository.MemElements.size() == 1;

        testService.deleteCakeOrderByID(1);
        assert testService.cakeOrderRepository.MemElements.isEmpty();
    }
}
