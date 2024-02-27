package domain;

import domain.CakeOrder;
import domain.CakeOrderValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CakeOrderTest {

    @Test
    void testConstructorAndGetters() {
        CakeOrder cakeOrder = new CakeOrder(1, "Chocolate Cake", "Bakery", "2023-12-31");

        assertEquals(1, cakeOrder.getId());
        assertEquals("Chocolate Cake", cakeOrder.getName());
        assertEquals("Bakery", cakeOrder.getLocation());
        assertEquals("2023-12-31", cakeOrder.getDate());
    }

    @Test
    void testSetters() {
        CakeOrder cakeOrder = new CakeOrder(1, "Chocolate Cake", "Bakery", "2023-12-31");

        cakeOrder.setId(2);
        cakeOrder.setName("Vanilla Cake");
        cakeOrder.setLocation("Home");
        cakeOrder.setDate("2023-12-25");

        assertEquals(2, cakeOrder.getId());
        assertEquals("Vanilla Cake", cakeOrder.getName());
        assertEquals("Home", cakeOrder.getLocation());
        assertEquals("2023-12-25", cakeOrder.getDate());
    }

    @Test
    void testToString() {
        CakeOrder cakeOrder = new CakeOrder(1, "Chocolate Cake", "Bakery", "2023-12-31");

        String expected = "Order{" +
                " id='1'," +
                " name='Chocolate Cake', " +
                "location='Bakery', " +
                "date=2023-12-31" +
                '}';

        assertEquals(expected, cakeOrder.toString());
    }

    @Test
    void testEquals() {
        CakeOrder cakeOrder1 = new CakeOrder(1, "Chocolate Cake", "Bakery", "2023-12-31");
        CakeOrder cakeOrder2 = new CakeOrder(2, "Vanilla Cake", "Home", "2023-12-25");
        CakeOrder cakeOrder3 = new CakeOrder(1, "Chocolate Cake", "Bakery", "2023-12-31");

        assertEquals(cakeOrder1, cakeOrder1);
        assertEquals(cakeOrder1, cakeOrder3);
        try {
            cakeOrder1.equals(null);
        } catch (NullPointerException e) {
            // Ensure that the correct exception is thrown
            assertEquals("Cannot compare with null", e.getMessage());
        }
    }
}
