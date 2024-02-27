package domain;

public class CakeOrderValidator {

    public static void validateCakeOrder(CakeOrder cakeOrder) {
        validateOrderId(cakeOrder.getId());
        validateOrderName(cakeOrder.getName());
        validateOrderLocation(cakeOrder.getLocation());
        validateOrderDate(cakeOrder.getDate());
    }

    private static void validateOrderId(int orderId) {
        if (orderId <= 0) {
            throw new IllegalArgumentException("Order ID must be greater than 0");
        }
    }

    private static void validateOrderName(String orderName) {
        if (orderName == null || orderName.trim().isEmpty()) {
            throw new IllegalArgumentException("Order name cannot be null or empty");
        }
    }

    private static void validateOrderLocation(String orderLocation) {
        if (orderLocation == null || orderLocation.trim().isEmpty()) {
            throw new IllegalArgumentException("Order location cannot be null or empty");
        }
    }

    private static void validateOrderDate(String orderDate) {
        if (orderDate == null) {
            throw new IllegalArgumentException("Order date cannot be null");
        }
    }
}
