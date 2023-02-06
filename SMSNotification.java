public class SMSNotification extends CustomNotification{

    // Constructor
    public SMSNotification(String to, String content){
        /*
         * The super keyword calls the parent's constructor
         */
        super(to, content);
    }

    // Method overriding
    public void send(){
        super.send(); // will call the send() method of parent
        System.out.println("Sending the above message via SMS");
    }
}

/*
 * Sent 'Good morning!' to +65 9739 8694
 * Sending via SMS
 */




 /*
  * LG TV
        Model A - 1a 5d 2d 3a 3d 5e dd
        Model B - 1a 5d 2d 3a 3d 5e ee
  */