package DesingPatterns.Creational;

interface Notification{
    void send(String msg);
}

class EmailNotification implements Notification{
    public void send(String msg){
        System.out.println(msg);
    }
}

class PushNotification implements Notification{

    @Override
    public void send(String msg) {
        System.out.println(msg);
    }
}
abstract class NotificationCreator{
   abstract Notification createNotification();

   public void send(String msg){
       Notification notification = createNotification();
       notification.send(msg);
   }
}

class EmailNotificationCreator extends NotificationCreator{

    @Override
    public Notification createNotification() {
        return new EmailNotification();
    }
}

class PushNotificationCreator extends NotificationCreator{

    @Override
    public Notification createNotification() {
        return new PushNotification();
    }
}
public class Factory {
    public static void main(String[] args) {
        // send notificationww
        NotificationCreator notificationCreator;

        notificationCreator = new EmailNotificationCreator();
        notificationCreator.send("Sending mail...");

        notificationCreator = new PushNotificationCreator();
        notificationCreator.send("Sending push notification...");


        // payment method, create obj at runtime
        PaymentCreator paymentCreator;
        paymentCreator = new CreditCardCreator();
        paymentCreator.pay(1000.0);

        paymentCreator = new UpiPaymentCreator();
        paymentCreator.pay(200.0);
    }
}


//another example

interface PaymentProcessor{
    void pay(double amt);
}

class UpiPaymentMethod implements PaymentProcessor{

    @Override
    public void pay(double amt) {
        System.out.println("Paying via upi. " + amt);
    }
}

class CreditCardPaymentMethod implements PaymentProcessor{

    public void pay(double amt){
        System.out.println("Paying via credit card. " + amt);
    }
}

abstract class PaymentCreator{
    public abstract PaymentProcessor createPaymentMethod();

    public void pay(double amt){
        PaymentProcessor payment1 = createPaymentMethod();
        payment1.pay(amt);
    }
}

class UpiPaymentCreator extends PaymentCreator{

    @Override
    public PaymentProcessor createPaymentMethod() {
        return new UpiPaymentMethod();
    }
}

class CreditCardCreator extends PaymentCreator{
    public PaymentProcessor createPaymentMethod(){
        return new CreditCardPaymentMethod();
    }
}