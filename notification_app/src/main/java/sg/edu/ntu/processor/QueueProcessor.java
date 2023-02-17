package sg.edu.ntu.processor;

import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import sg.edu.ntu.notification.CustomNotification;
import sg.edu.ntu.queue.NotificationQueue;

public class QueueProcessor {
    private static ExecutorService executor;

    private QueueProcessor(){}

    public static void init(int threadPool){
        if(executor == null) executor = Executors.newFixedThreadPool(threadPool);
    }

    public static void start() throws InterruptedException{
        boolean hasQueue = true;
        do{
            Queue<CustomNotification> queue = NotificationQueue.getInstance();
            int queueSize = queue.size();
            System.out.println(Thread.currentThread().getName()+" - Queue size: "+queueSize);
            if(queueSize <= 0) {
                System.out.println(Thread.currentThread().getName()+" - Queue is empty. Breaking out of sleep and end this program.");
                hasQueue = false;
                break;
            }

            ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executor;  
            int totalPoolSize = threadPoolExecutor.getCorePoolSize();   
            int activePoolSize = threadPoolExecutor.getActiveCount();
            int availablePoolSize = totalPoolSize - activePoolSize;
            System.out.println(Thread.currentThread().getName()+" - Available pool size: "+availablePoolSize);
            if(availablePoolSize > 0){
                CustomNotification notification = queue.poll();
                executor.submit(() -> {                   
                    notification.send();
                });
            }else{
                Thread.sleep(500);
            }
                
        }while(hasQueue);

        executor.shutdown();
    }
}
