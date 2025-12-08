package SolidPrinciple;
class NeftPayment{
    void pay(Double amount){
        System.out.println("Paying " + amount + " via NEFT");
    }
}
class PaymentProcessors{
    NeftPayment neftPayment = new NeftPayment();

    void makePayment(double amt){
        neftPayment.pay(amt);
    }
}
public class DependencyInversionPrinciple {
    public static void main(String[] args) {
        PaymentProcessors paymentProcessors = new PaymentProcessors();
        paymentProcessors.makePayment(100.0);

        PaymentProcessor1 paymentProcessor1 = new PaymentProcessor1(new UPIPayment());
        paymentProcessor1.makePayment(100.0);
    }
}

interface Payment{
    void pay(double amount);
}

class UPIPayment implements Payment{

    @Override
    public void pay(double amount) {
        System.out.println("Paying " + amount + " via UPI.");
    }
}

class PaymentProcessor1{

    private Payment payment;

    PaymentProcessor1(Payment payment){
        this.payment = payment;
    }

    void makePayment(Double amt){
        this.payment.pay(amt);
    }
}

