/*
Interface "Payment"
to defines "processPayment" method
to be implemented by all payments classes
 */
interface Payment {
    void processPayment(double amount);
}

/*
Class "CreditCardPayment"
which implement to "Payment" interface
and provide specific implementation
of "processPayment" method
 */
class CreditCardPayment implements Payment {
    @Override
    public void processPayment(double amount) {
        // Processing credit card payment
        System.out.println("Processing credit card payment of $" + amount);
    }
}

/*
Class "PayPalPayment"
which implement to "Payment" interface
and provide specific implementation
of "processPayment" method
 */
class PayPalPayment implements Payment {
    @Override
    public void processPayment(double amount) {
        // Processing credit card payment
        System.out.println("Processing PayPal payment of $" + amount);
    }
}

/*
Class "BankTransferPayment"
for new payment methods
which implement to "Payment" interface
and provide specific implementation
of "processPayment" method
 */
class BankTransferPayment implements Payment {
    @Override
    public void processPayment(double amount) {
        // Processing credit card payment
        System.out.println("Processing bank transfer payment of $" + amount);
    }
}

/*
Use "Payment" interface to processing payment.
It allows to add new payment methods without changing code
 */
class PaymentProcessor {
    private Payment payment;

    public PaymentProcessor(Payment payment) {
        this.payment = payment;
    }

    public void executePayment(double amount) {
        payment.processPayment(amount);
    }
}

// TEST
class Task_1 {
    public static void main(String[] args) {
        Payment creditCardPayment = new CreditCardPayment();
        PaymentProcessor paymentProcessor1 = new PaymentProcessor(creditCardPayment);
        paymentProcessor1.executePayment(19.99);

        Payment payPalPayment = new PayPalPayment();
        PaymentProcessor paymentProcessor2 = new PaymentProcessor(payPalPayment);
        paymentProcessor2.executePayment(199.99);

        Payment bankTransferPayment = new BankTransferPayment();
        PaymentProcessor paymentProcessor3 = new PaymentProcessor(bankTransferPayment);
        paymentProcessor3.executePayment(1999.99);
    }
}