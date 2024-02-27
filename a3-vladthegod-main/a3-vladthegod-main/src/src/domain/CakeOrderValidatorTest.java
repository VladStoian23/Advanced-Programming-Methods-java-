package domain;

import domain.CakeOrder;
import domain.CakeOrderValidator;
import org.junit.Test;

import static org.junit.Assert.assertThrows;

public class CakeOrderValidatorTest {

    @Test
    public void validateOrderIdTest() {
        CakeOrder cakeOrder = new CakeOrder(1, "Chocolate Cake", "Bakery", "2023-12-31");
        try {
            CakeOrderValidator.validateCakeOrder(cakeOrder);
        } catch (IllegalArgumentException e) {
            System.out.println("Illegal arguments");
        }

        CakeOrder cakeOrder1 = new CakeOrder(-1, "Vanilla Cake", "Home", "2023-12-25");
        try {
            CakeOrderValidator.validateCakeOrder(cakeOrder1);
        } catch (IllegalArgumentException e) {
            System.out.println("Illegal arguments");
        }
    }

    @Test
    public void validateOrderNameTest() {
        CakeOrder cakeOrder = new CakeOrder(1, "Chocolate Cake", "Bakery", "2023-12-31");
        try {
            CakeOrderValidator.validateCakeOrder(cakeOrder);
        } catch (IllegalArgumentException e) {
            System.out.println("Illegal arguments");
        }

        CakeOrder cakeOrder1 = new CakeOrder(2, null, "Home", "2023-12-25");
        try {
            CakeOrderValidator.validateCakeOrder(cakeOrder1);
        } catch (IllegalArgumentException e) {
            System.out.println("Illegal arguments");
        }
    }

    @Test
    public void validateOrderLocationTest() {
        CakeOrder cakeOrder = new CakeOrder(1, "Chocolate Cake", "Bakery", "2023-12-31");
        try {
            CakeOrderValidator.validateCakeOrder(cakeOrder);
        } catch (IllegalArgumentException e) {
            System.out.println("Illegal arguments");
        }

        CakeOrder cakeOrder1 = new CakeOrder(2, "Vanilla Cake", null, "2023-12-25");
        try {
            CakeOrderValidator.validateCakeOrder(cakeOrder1);
        } catch (IllegalArgumentException e) {
            System.out.println("Illegal arguments");
        }
    }

    @Test
    public void validateOrderDateTest() {
        CakeOrder cakeOrder = new CakeOrder(1, "Chocolate Cake", "Bakery", "2023-12-31");
        try {
            CakeOrderValidator.validateCakeOrder(cakeOrder);
        } catch (IllegalArgumentException e) {
            System.out.println("Illegal arguments");
        }

        CakeOrder cakeOrder1 = new CakeOrder(2, "Vanilla Cake", "Home", null);
        try {
            CakeOrderValidator.validateCakeOrder(cakeOrder1);
        } catch (IllegalArgumentException e) {
            System.out.println("Illegal arguments");
        }
    }
}
