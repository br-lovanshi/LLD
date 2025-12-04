package SolidPrinciple;

// problem everytime need to modify the existing classes
class PaymentProcessor{
    void CardPayment(){
        System.out.println("Pay via card");
    }

    void Upi(){
        System.out.println("Pay via Upi");
    }
}
class CheckoutService{
    PaymentProcessor paymentProcessor;

    CheckoutService(PaymentProcessor paymentProcessor){
        this.paymentProcessor = paymentProcessor;
    }

    void checkout(String type){
        if("CARD".equalsIgnoreCase(type)){
            paymentProcessor.CardPayment();
        }
        if("UPI".equalsIgnoreCase(type)){
            paymentProcessor.Upi();
        }
    }
}


// OPC

interface PaymentProcessorInter{
    void processPayment();
}

class CardPayment implements PaymentProcessorInter{

    public void processPayment(){
        System.out.println("Paying via card.");
    }
}

class UpiPayment implements PaymentProcessorInter{

    @Override
    public void processPayment() {
        System.out.println("Paying via upi.");
    }
}

class CheckoutServiceImpl{

    void pay(PaymentProcessorInter paymentProcessorInter){
        paymentProcessorInter.processPayment();
    }
}

public class OpenClose {
    public static void main(String[] args) {
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        CheckoutService checkoutService = new CheckoutService(paymentProcessor);
        checkoutService.checkout("UPI");

        // opc solution
        CheckoutServiceImpl checkoutService1 = new CheckoutServiceImpl();
        checkoutService1.pay(new CardPayment());
        checkoutService1.pay(new UpiPayment());
    }
}
