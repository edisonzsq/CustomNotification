package sg.edu.ntu.notification;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import sg.edu.ntu.api.Connectable;

public class EmailNotification extends CustomNotification implements Connectable{
    public EmailNotification(String to, String content){
        super(to, content);
        this.init();
    }

    @Override
    public void send(){

        System.out.println(Thread.currentThread().getName()+" - Sending email to "+this.to+" asynchronously with message "+this.content);                
        try {        
            Thread.sleep(1000);                
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException("Thread.sleep encountered error");
        }            
    }

    @Override
    public void init() {
        //System.out.println("Initialize all properties needed to connect to email server.");
        
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
