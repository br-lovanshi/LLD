package Projects;

import Projects.model.*;

import java.util.ArrayList;
import java.util.Arrays;

public class FoodDeliveryLLD {
    public static void main(String[] args) {

        // create restaurant manager
        RestaurantManager restaurantManager = RestaurantManager.getRestaurantManager();
        // create menuItems
        MenuItem menuItem = new MenuItem((int)Math.random(), "Panjabi Thali", "PTHALI", 200);
        MenuItem menuItem1 = new MenuItem((int) Math.random(), "Alu Paratha", "APARATHA", 100);
        // create restaurant
        Restaurant restaurant = new Restaurant((int) Math.random(), "Apna Khana","Vastrapur", Arrays.asList(menuItem, menuItem1));
        restaurantManager.addRestaurant(restaurant);
        // create customer
        Customer ram = new Customer((int)Math.random(), "Ram", "Vastrapur");

        // order items
        OrderItem orderItem = new OrderItem((int)Math.random(), new ArrayList<>(), restaurant);
        orderItem.addItems(restaurant.getMenuItemList().get(0));
        orderItem.addItems(restaurant.getMenuItemList().get(1));
        // place order
        Orders order = new Orders((int)Math.random(), orderItem, ram, orderItem.totalPrice());
        System.out.println(order.toString());


    }
}
