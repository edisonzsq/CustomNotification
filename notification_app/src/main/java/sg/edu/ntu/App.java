package sg.edu.ntu;

import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import sg.edu.ntu.notification.CustomNotification;
import sg.edu.ntu.notification.EmailNotification;
import sg.edu.ntu.processor.QueueProcessor;
import sg.edu.ntu.queue.NotificationQueue;

public class App 
{

    public static void main( String[] args )
    {
        System.out.println("=============================== FRESH START ===============================");
        System.out.println("Main Thread: "+Thread.currentThread().getName());
        Queue<CustomNotification> queue = NotificationQueue.getInstance();

        // Insert five objects into the queue
        int queueSeederSize = 10;
        for(int i=0 ; i<queueSeederSize ; i++){
            CustomNotification n = new EmailNotification("index:"+i+" email: Daniel@mail.com", "I am content with index "+i);
            queue.add(n);
        }
        
        int threadPoolSize = 3;
        QueueProcessor.init(threadPoolSize);
        try {
            QueueProcessor.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
