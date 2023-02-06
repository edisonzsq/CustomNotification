import java.util.ArrayList;
import java.util.List;

public class CustomNotification {
 
    public static boolean isOperating = true;

    // By default, private.
    String to;
    String content;
    List<String> histories;
    
    // default
    public CustomNotification(){

    }

    // with values initialization
    public CustomNotification(String to, String content){
        this.to = to;
        this.content = content;
        histories = new ArrayList<String>();
    }

    private void addHistory(String content){
        histories.add(content);
    }

    protected void printHistory(){

        // lambda expression in java
        histories.forEach(h -> {
            System.out.println(h);
        });
    }

    protected void send(){

        if(!CustomNotification.isOperating){
            System.out.println("Notification is not operating at the moment");
            return; // do not process anything below this line
        }

        System.out.println("Sent '"+this.content+"' to "+this.to);
        addHistory(this.content);
    }

    // accessor methods
    public String getTo() {
        return to;
    }
    public void setTo(String to) {        
        this.to = to;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
}
