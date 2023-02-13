package sg.edu.ntu;

import org.apache.log4j.BasicConfigurator;  
import org.apache.log4j.LogManager;  
import org.apache.log4j.Logger;  

import sg.edu.ntu.notification.CustomNotification;
import sg.edu.ntu.notification.EmailNotification;
import sg.edu.ntu.notification.SMSNotification;

/**
 * Hello world!
 *
 */
public class App 
{
    private static final Logger logger = LogManager.getLogger(App.class);

    public static void main( String[] args )
    {
        CustomNotification n1 = new SMSNotification("+65 9123 4567", "Good morning!");
        n1.send();
        System.out.println("=========================================================");
        CustomNotification n2 = new EmailNotification("edison@mail.com", "Good afternoon!");
        n2.send();
    }

    public static void testLogger(){
        logger.debug("Debug message");
        logger.info("Info message");
        logger.warn("Warning message");
        logger.error("Error message");
        logger.fatal("Fatal message");
    }
}
