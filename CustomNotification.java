import java.util.Date;

public class CustomNotification{

    static boolean isOperating = true;
    public static enum NotificationType {
        SMS,
        EMAIL
    }

    String content;
    String to;
    Date timestamp;
    NotificationType type;

    public CustomNotification(String to, String content, NotificationType type){
        this.to = to;
        this.content = content;
        this.type = type;
    }

    public void send(){
        System.out.println("Sent '"+this.content+"' to "+this.to+" via "+this.type);
    }

    public void send(String cc){
        System.out.println("Sent '"+this.content+"' to "+this.to+" via "+this.type+" cc: "+cc);
    }

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getTo() {
        return to;
    }
    public void setTo(String to) {
        this.to = to;
    }
    public Date getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public static void setOperating(boolean isOperating){
        CustomNotification.isOperating = isOperating;
    }

    public static boolean getOperating(){
        return isOperating;
    }
}