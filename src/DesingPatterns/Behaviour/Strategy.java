package DesingPatterns.Behaviour;

interface Payment{
    void pay();
}

class Upi implements Payment{

    @Override
    public void pay() {
        System.out.println("Upi");
    }
}

class Card implements Payment{
    @Override
    public void pay() {
        System.out.println("Card");
    }
}

class PaymentService{
   private Payment payment;
   public void makePayment(Payment payment){
       this.payment = payment;
       this.payment.pay();
   }
}
public class Strategy{
    public static void main(String[] args) {
        PaymentService paymentService = new PaymentService();
        paymentService.makePayment(new Upi());
        paymentService.makePayment(new Card());


        // shippingCart
        Order order = new Order("Bhagwat Gita", 2, "ZONEA");
        ShippingService shippingService = new ShippingService(new FlatRateStrategy(100));

        ShippingStrategy weight = new WeightRateStrategy(5.0);
        shippingService.setShippingStrategy(weight);
        ShippingStrategy distance = new DistanceRateStrategy(11.0);
        shippingService.setShippingStrategy(distance);
        shippingService.calculateCharge(order);
    }



}

class ShippingService{
    private ShippingStrategy shippingStrategy;
    ShippingService(ShippingStrategy shippingStrategy){
        this.shippingStrategy = shippingStrategy; // default strategy
    }

    public void setShippingStrategy(ShippingStrategy shippingStrategy) {
        this.shippingStrategy = shippingStrategy;
    }

    public void calculateCharge(Order order){
      double charges =  this.shippingStrategy.calculateCost(order);
        System.out.println(charges +" rs for " + this.shippingStrategy.getClass().getName());
    }
}
    // shipping strategy to calculate the price at runtime
interface ShippingStrategy{
    double calculateCost(Order order);
}

class FlatRateStrategy implements ShippingStrategy{
    private double rate;
    FlatRateStrategy(double rate){
        this.rate = rate;
    }

    @Override
    public double calculateCost(Order order) {
        return rate;
    }
}

class WeightRateStrategy implements ShippingStrategy{
    private double rate;
    WeightRateStrategy(Double rate){
        this.rate = rate;
    }


    @Override
    public double calculateCost(Order order) {
        return order.getProductWeight() * rate;
    }
}

class DistanceRateStrategy implements ShippingStrategy{
    private double rate;
    DistanceRateStrategy(double rate){
        this.rate = rate;
    }
    @Override
    public double calculateCost(Order order) {
       switch (order.getDestinationZone()){
           case "ZONEA": return 5 * rate;
           case "ZONEB": return 7 * rate;
           default: return 10 * rate;
       }
    }
}

class Order{
    private String productDetails;
    private int productWeight;
    private String destinationZone;

    public Order(String productDetails, int productWeight, String destinationZone) {
        this.productDetails = productDetails;
        this.productWeight = productWeight;
        this.destinationZone = destinationZone;
    }

    public String getProductDetails() {
        return productDetails;
    }

    public int getProductWeight() {
        return productWeight;
    }

    public String getDestinationZone() {
        return destinationZone;
    }
}