package food.main;

import food.model.FoodOrder;
import food.model.RegularOrder;
import food.model.PremiumOrder;
import food.utility.OrderUtility;
import food.service.Discountable;

public class Main {

    public static void main(String[] args) {

        FoodOrder.setRestaurantName("FoodExpress");

        FoodOrder[] orders = new FoodOrder[6];

        orders[0] = new RegularOrder(101, "Rahul", 500);
        orders[1] = new PremiumOrder(102, "Aman", 1200);
        orders[2] = new RegularOrder(103, "Priya", 800);
        orders[3] = new PremiumOrder(104, "Neha", 1500);
        orders[4] = new RegularOrder(105, "Karan", 600);
        orders[5] = new PremiumOrder(106, "Simran", 2000);

        System.out.println("======================================");
        System.out.println("       ONLINE FOOD DELIVERY");
        System.out.println("======================================");

        for (FoodOrder order : orders) {

            // Validate customer name
            if (!OrderUtility.validateCustomerName(
                    order.getCustomerName())) {

                System.out.println("Invalid customer name.");
                continue;
            }

            // Validate amount
            if (!OrderUtility.validateAmount(
                    order.getAmount())) {

                System.out.println("Invalid amount.");
                continue;
            }

            // Display order information
            OrderUtility.generateOrderSummary(order);
        }

        System.out.println();

        // Display total number of orders
        FoodOrder.displayTotalOrders();
    }
}