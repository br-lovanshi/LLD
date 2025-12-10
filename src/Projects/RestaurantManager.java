package Projects;

import Projects.model.Restaurant;

import java.util.HashSet;

public class RestaurantManager {
    private volatile static RestaurantManager restaurantManager;
    private HashSet<Restaurant> restaurantList;

    private RestaurantManager(){
        this.restaurantList = new HashSet<>();
    }

    public synchronized static RestaurantManager getRestaurantManager(){

        if(restaurantManager == null){
            restaurantManager = new RestaurantManager();
        }

        return restaurantManager;
    }

    public void addRestaurant(Restaurant restaurant){
        restaurantList.add(restaurant);
    }
}


// Singleton pattern