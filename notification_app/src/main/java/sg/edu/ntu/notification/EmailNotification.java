package sg.edu.ntu.notification;

import sg.edu.ntu.api.Connectable;

public class EmailNotification extends CustomNotification implements Connectable{
    public EmailNotification(String to, String content){
        super(to, content);
        this.init();
    }

    @Override
    public void send(){
        // Add code
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
