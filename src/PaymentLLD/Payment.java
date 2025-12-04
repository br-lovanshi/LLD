package PaymentLLD;

public class Payment {
    public static void main(String[] args) {
        PaymentProcessor paymentProcessor = new RazorpayPayment();
        paymentProcessor.pay();
    }
}
