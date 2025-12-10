package Projects.model;

import java.util.List;

public class OrderItem {
    private int id;
    private List<MenuItem> menuItemList;
    private Restaurant restaurant;

    public OrderItem(int id, List<MenuItem> menuItemList, Restaurant restaurant) {
        this.id = id;
        this.menuItemList = menuItemList;
        this.restaurant = restaurant;
    }

    public void addItems(MenuItem menuItem){
        menuItemList.add(menuItem);
    }

    public Double totalPrice(){
        double price = 0.0;

        for(MenuItem menuItem: menuItemList){
            price += menuItem.getPrice();
        }

        return price;
    }
}
