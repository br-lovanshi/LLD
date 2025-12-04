package PaymentLLD;

public class PaypalPayment implements PaymentProcessor{
    @Override
    public void pay() {
        System.out.println("Paying via paypal");
    }
}
