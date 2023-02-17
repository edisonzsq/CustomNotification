package sg.edu.ntu.notification;

import java.util.concurrent.CompletableFuture;
import sg.edu.ntu.api.Connectable;

public class EmailNotification extends CustomNotification implements Connectable{
    public EmailNotification(String to, String content){
        super(to, content);
        this.init();
    }

    @Override
    public void send(){

        /*
         * The recommended way to spawn a new thread after Java 8. 
         */
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Sending email to "+this.to+" asynchronously");    
            if(!CustomNotification.isOperating) throw new RuntimeException("notification is currently no operating");  
            return "done";
        });

        /*
         * Without this line, the main thread will end before this thread. Therefore, we do not see the message 
         * bring printed.
         * 
         * This line will be invoked when the thread ended without exception thrown
         */
        future.thenAccept(result -> System.out.println(result)); // print "done"

        /*
         * When a RuntimeException occurred, this function will be invoked.
         */
        future.exceptionally((throwable)->{
            // handle throwable
            return "error";
        });
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
