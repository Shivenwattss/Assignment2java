package food.utility;

import food.model.FoodOrder;
import food.service.Discountable;

public class OrderUtility {

    // Validate amount
    public static boolean validateAmount(double amount) {

        return amount > 0;
    }

    // Validate customer name
    public static boolean validateCustomerName(String name) {

        return name != null &&
               !name.trim().isEmpty();
    }

    // Generate order summary
    public static void generateOrderSummary(FoodOrder order) {

        double discount = 0;

        if (order instanceof Discountable) {
            Discountable d = (Discountable) order;
            discount = d.applyDiscount();
        }

        double deliveryCharge = order.calculateDeliveryCharge();

        double finalAmount =
                order.getAmount()
                - discount
                + deliveryCharge;

        System.out.println("--------------------------------------");
        System.out.println("Restaurant       : "
                + FoodOrder.getRestaurantName());

        System.out.println("Order ID         : "
                + order.getOrderId());

        System.out.println("Customer         : "
                + order.getCustomerName());

        System.out.printf("Food Amount      : ₹%.2f%n",
                order.getAmount());

        System.out.printf("Discount         : ₹%.2f%n",
                discount);

        System.out.printf("Delivery Charge  : ₹%.2f%n",
                deliveryCharge);

        System.out.printf("Final Payable    : ₹%.2f%n",
                finalAmount);

        System.out.println("--------------------------------------");
    }
}