
public class MainClass {
    public static void main(String[] args) {

        CustomNotification n1 = new SMSNotification("+65 9123 4567", "Good morning!");
        n1.send();
        System.out.println("=========================================================");
        CustomNotification n2 = new EmailNotification("edison@mail.com", "Good afternoon!");
        n2.send();

        System.out.println("=========================================================");
        AppAuditLogSender sender = new AppAuditLogSender();
        sender.checkHasNetworkConnection();

    }
}