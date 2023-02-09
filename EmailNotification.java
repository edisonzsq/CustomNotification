public class EmailNotification extends CustomNotification{
    public EmailNotification(String to, String content){
        super(to, content);
        this.init();
    }

    @Override
    public void send(){
        if(checkHasNetworkConnection())
            System.out.println("Sending email to "+this.to+" with message: "+this.content);
        else
            System.out.println("Unable to send Email due to network error");
    }

    @Override
    public void init() {
        System.out.println("Initialize all properties needed to connect to email server.");
        
    }

    @Override
    public boolean checkHasNetworkConnection() {
        System.out.println("Check whether has network connection");
        boolean isSuccess = false;
        if(isSuccess){
            CustomNotification.isOperating = true;
        }
        return isSuccess;
    }
}
