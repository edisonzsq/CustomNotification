public class AppAuditLogSender implements Connectable{


    public AppAuditLogSender(){
        init();
    }

    @Override
    public void init() {
        System.out.println("Initialize all properties needed to connect to application audit log server");
        
    }

    @Override
    public boolean checkHasNetworkConnection() {
        System.out.println("Check for network connection");
        return true;
    }
    
}
