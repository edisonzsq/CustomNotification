package sg.edu.ntu.queue;

import java.util.LinkedList;
import java.util.Queue;

import sg.edu.ntu.notification.CustomNotification;

// Singleton Pattern
public class NotificationQueue {

    private static Queue<CustomNotification> instance; // private static variable

    private NotificationQueue(){} // private constructor to avoid "new" keyword being used

    // return the private instance
    public static Queue<CustomNotification> getInstance(){
        if(instance == null){
            instance = new LinkedList<CustomNotification>(); // create an instance if the instance is null
        }
        return instance;
    }
}
