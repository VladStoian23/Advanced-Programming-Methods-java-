package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
public class BirthdayCakeTest {

    @Test
    void testConstructorAndGetters()
    {
        BirthdayCake cake=new BirthdayCake(1,"Chocolate","Chocolate");

        assertEquals(1,cake.getId());
        assertEquals("Chocolate",cake.getName());
        assertEquals("Chocolate",cake.getFlavour());

    System.out.println("Test Constructor done !");
    }
    @Test
    void testSetters() {
        BirthdayCake cake = new BirthdayCake(1, "Chocolate", "Chocolate");
        cake.setId(2);
        cake.setName("Aurel");
        cake.setFlavour("Vanilla");

        assertEquals(2, cake.getId());
        assertEquals("Vanilla", cake.getFlavour());
        assertEquals("Aurel", cake.getName());
        System.out.println("Test Setters done !");
    }

    @Test
    void testToString() {
        BirthdayCake cake = new BirthdayCake(1, "Chocolate Delight", "Chocolate");

        String expected = "BirthdayCake{" +
                "flavour='Chocolate', " +
                "name='Chocolate Delight', " +
                "id=1" +
                '}';

        assertEquals(expected, cake.toString());
        System.out.println("Test tostring done !");
    }

    @Test
    void testEquals() {
        BirthdayCake cake1 = new BirthdayCake(1, "Chocolate Delight", "Chocolate");
        BirthdayCake cake2 = new BirthdayCake(2, "Vanilla Dream", "Vanilla");
        BirthdayCake cake3 = new BirthdayCake(1, "Chocolate Delight", "Chocolate");

        assertEquals(cake1, cake1);
        assertEquals(cake1, cake3);
        assertNotEquals(cake2, cake3);
        System.out.println("Test Equals by id  done !");
    }
}
