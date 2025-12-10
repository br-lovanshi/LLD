package Projects.model;

public class Orders {
    private int id;
//    private Restaurant restaurant;
    private OrderItem orderItem;
    private Customer customer;
    private Double orderAmt;

    public Orders(int id, OrderItem orderItem, Customer customer, double amt) {
        this.id = id;
        this.orderItem = orderItem;
        this.customer = customer;
        this.orderAmt = amt;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", orderItem=" + orderItem +
                ", customer=" + customer +
                ", orderAmt=" + orderAmt +
                '}';
    }
}
