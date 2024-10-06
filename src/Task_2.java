/*
Interface "Notification"
which defines "send" method
to be implemented by all notification classes
 */
interface Notification {
    void send(String message, String recipient);
}

/*
Class "SMSNotification"
implement "Notification" interface
and provide specific implementations
of "send" methods
 */
class SMSNotification implements Notification {
    @Override
    public void send(String message, String recipient) {
        // Sending SMS notification
        System.out.println("Sending SMS to " + recipient + ": " + message);
    }
}

/*
Class "EmailNotification"
implement "Notification" interface
and provide specific implementations
of "send" methods
 */
class EmailNotification implements Notification {
    @Override
    public void send(String message, String recipient) {
        // Sending Email notification
        System.out.println("Sending Email to " + recipient + ": " + message);
    }
}

/*
Class "PushNotification"
implement "Notification" interface
and provide specific implementations
of "send" methods
 */
class PushNotification implements Notification {
    @Override
    public void send(String message, String recipient) {
        // Sending Push notification
        System.out.println("Sending Push to " + recipient + ": " + message);
    }
}

/*
Class "NotificationService"
implement "Notification" interface to send notification
and allows to add new types of notification
without changing code
 */
class NotificationService {
    private Notification notification;

    public NotificationService(Notification notification) {
        this.notification = notification;
    }

    public void sendNotification(String message, String recipient) {
        notification.send(message, recipient);
    }

    public void sendBulkNotification(String message, String[] recipients) {
        for (String recipient : recipients) {
            notification.send(message, recipient);
        }
    }
}

/*
Class "SlackNotification"
implement "Notification" interface
and provide specific implementations
of "send" methods
(new notification type without modifying code)
 */
class SlackNotification implements Notification {
    @Override
    public void send(String message, String recipient) {
        // Sending Slack notification
        System.out.println("Sending Slack to " + recipient + ": " + message);
    }
}

// TEST
public class Task_2 {
    public static void main(String[] args) {
        Notification smsNotification = new SMSNotification();
        NotificationService smsService = new NotificationService(smsNotification);
        smsService.sendNotification("Hello via SMS", "+7 707 649 59 12");

        Notification emailNotification = new EmailNotification();
        NotificationService emailService = new NotificationService(emailNotification);
        emailService.sendNotification("Hello via Email", "AstanaITUniversity@gmail.com");

        Notification pushNotification = new PushNotification();
        NotificationService pushService = new NotificationService(pushNotification);
        pushService.sendNotification("Hello via Push", "NiKiT0$");
//
        String[] recipients = {"Nikita", "Sanat", "Zhenis", "Beibars"};
        pushService.sendBulkNotification("Hello everyone via Bulk Push Notification", recipients);
    }
}
