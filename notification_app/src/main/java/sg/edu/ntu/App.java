package sg.edu.ntu;

import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import sg.edu.ntu.notification.CustomNotification;
import sg.edu.ntu.notification.EmailNotification;
import sg.edu.ntu.notification.SMSNotification;
import sg.edu.ntu.queue.NotificationQueue;

public class App 
{

    public static void main( String[] args )
    {
        Queue<CustomNotification> queue = NotificationQueue.getInstance();

        // Insert five objects into the queue
        for(int i=0 ; i<5 ; i++){
            CustomNotification n = new EmailNotification("index:"+i+" email: Daniel@mail.com", "HELLO");
            queue.add(n);
        }
        
        System.out.println("Queue Size: "+queue.size());

        // Declare a thread pool executor
        ExecutorService executor = Executors.newFixedThreadPool(2); 

        // Consume one thread to process one item in the queue
        executor.submit(() -> {
            CustomNotification toProcess = queue.poll(); // Take out one item, automatically reduce size by one
            toProcess.send();
            System.out.println("End Submit Queue Size: "+queue.size());
        });
       
        // Main thread stops here
    }

}
