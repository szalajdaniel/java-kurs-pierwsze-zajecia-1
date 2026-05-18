package main.java.lekcje.abstract_vehicle;

public class NotificationService {
    private final String serviceName;

    public NotificationService(String serviceName) {
        this.serviceName = serviceName;
    }

    public NotificationService() {
        this("Standard-Service");
    }

    String getServiceName() {
        return serviceName;
    }
}
