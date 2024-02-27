package domain;

import org.junit.Test;
public class BirthdayCakeValidatorTest {
    @Test
    public void validateCakeIdTest() {
        BirthdayCake cake = new BirthdayCake(1, "Chocolate Delight", "Chocolate");
        try {
            BirthdayCakeValidator.validateBirthdayCake(cake);
        } catch (IllegalArgumentException e) {
            System.out.println("Illegal arguments");
        }

        BirthdayCake cake1 = new BirthdayCake(-1, "Vanilla Dream", "Vanilla");
        try {
            BirthdayCakeValidator.validateBirthdayCake(cake1);
        } catch (IllegalArgumentException e) {
            System.out.println("Illegal arguments");
        }
    }

    @Test
    public void validateCakeNameTest() {
        BirthdayCake cake = new BirthdayCake(1, "Chocolate Delight", "Chocolate");
        try {
            BirthdayCakeValidator.validateBirthdayCake(cake);
        } catch (IllegalArgumentException e) {
            System.out.println("Illegal arguments");
        }

        BirthdayCake cake1 = new BirthdayCake(2, null, "Vanilla");
        try {
            BirthdayCakeValidator.validateBirthdayCake(cake1);
        } catch (IllegalArgumentException e) {
            System.out.println("Illegal arguments");
        }
    }

    @Test
    public void validateCakeFlavourTest() {
        BirthdayCake cake = new BirthdayCake(1, "Chocolate Delight", "Chocolate");
        try {
            BirthdayCakeValidator.validateBirthdayCake(cake);
        } catch (IllegalArgumentException e) {
            System.out.println("Illegal arguments");
        }

        BirthdayCake cake1 = new BirthdayCake(2, "Vanilla Dream", null);
        try {
            BirthdayCakeValidator.validateBirthdayCake(cake1);
        } catch (IllegalArgumentException e) {
            System.out.println("Illegal arguments");
        }
    }



}
