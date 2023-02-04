public class MainClass{
    public static void main(String[] args){

        // Default constructor
        CustomNotification notification = new CustomNotification();
        notification.setTo("+65 9739 8694");
        notification.setContent("Good morning!");
        notification.send(CustomNotification.Channel.SMS);

        // CustomNotification.isOperating = false; 

        // Value initialization constructor
        CustomNotification n2 = new CustomNotification("daniel@mail.com", "Good afternoon!", CustomNotification.Channel.EMAIL);
        n2.send();
    }  
}