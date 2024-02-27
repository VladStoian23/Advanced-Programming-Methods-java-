package domain;

public class BirthdayCakeValidator {

    public static void validateBirthdayCake(BirthdayCake birthdayCake) {
        validateCakeId(birthdayCake.getId());
        validateCakeName(birthdayCake.getName());
        validateCakeFlavour(birthdayCake.getFlavour());
    }

    private static void validateCakeName(String cakeName) {
        if (cakeName == null || cakeName.trim().isEmpty()) {
            throw new IllegalArgumentException("Cake name cannot be null or empty");
        }
    }

    private static void validateCakeId(Integer id) {
        if (id <= 0)
            throw new IllegalArgumentException("Cake Id must be >0");
    }

    private static void validateCakeFlavour(String cakeFlavour) {
        if (cakeFlavour == null || cakeFlavour.trim().isEmpty()) {
            throw new IllegalArgumentException("Cake flavour cannot be null or empty");
        }


    }
}