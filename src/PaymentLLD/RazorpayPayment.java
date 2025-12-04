package PaymentLLD;

public class RazorpayPayment implements PaymentProcessor{
    @Override
    public void pay() {
        System.out.println("Paying via Razorpay.");
    }
}
