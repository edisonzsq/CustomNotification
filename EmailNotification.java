public class EmailNotification extends CustomNotification{
    public EmailNotification(String to, String content){
        super(to, content);
    }

    public void send(){
        super.send();
        System.out.println("Sending the above message via email");
    }
}
