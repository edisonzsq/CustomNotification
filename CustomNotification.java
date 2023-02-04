public class CustomNotification {
 
    public static boolean isOperating = true;

    /*
     * Use of enum to:
     *  - restrict option
     *  - standardize value
     */
    public static enum Channel {
        SMS, EMAIL
    }

    Channel type;

    // By default, private.
    String to;
    String content;
    
    // default
    public CustomNotification(){

    }

    // with values initialization
    public CustomNotification(String to, String content, Channel type){
        this.to = to;
        this.content = content;
        this.type = type;
    }

    // Getter and Setter
    public String getTo() {
        return to;
    }
    public void setTo(String to) {        
        this.to = to;
    }

    /*
     * public - accessible outside of this class
     * private - accessible within this class
     * protected - accessible within and child of this class
     * 
     * 
     */
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    public void send(){

        if(!CustomNotification.isOperating){
            System.out.println("Notification is not operating at the moment");
            return; // do not process anything below this line
        }

        System.out.println("Sent '"+this.content+"' to "+this.to+" via "+this.type);
    }

    // method overloading
    public void send(Channel type){
        this.type = type;
        this.send();
    }
}
