package Projects.model;

public class MenuItem {
    private int id;
    private String name;
    private String code;
    private double price;

    public MenuItem(int id, String name, String code, double price) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", price=" + price +
                '}';
    }
}
