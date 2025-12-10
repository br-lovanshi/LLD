package Projects.model;

import java.util.List;

public class Restaurant {
    private int id;
    private String name;
    private String address;
    private List<MenuItem> menuItemList;

    public Restaurant(int id, String name, String address, List<MenuItem> menuItemList) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.menuItemList = menuItemList;
    }

    public void setMenuItemList(List<MenuItem> manueItemList) {
        this.menuItemList = manueItemList;
    }

    public List<MenuItem> getMenuItemList(){
        return this.menuItemList;
    }
}
