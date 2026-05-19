package main.java.lekcje.abstract_vehicle;

abstract class Vehicle {
    private final String brand;
    private final String model;
    private NotificationService notificationService;

    public Vehicle(String brand, String model) {
        this.brand = brand;
        this.model = model;
        this.notificationService = new NotificationService();
    }

    public Vehicle(String brand, String model, String notificationServiceName) {
        this.brand = brand;
        this.model = model;
        this.notificationService = new NotificationService(notificationServiceName);
    }

    public abstract void drive();

    @Override
    public String toString() {
        return String.format("Pojazd:\n  %s %s\n serwis = %s ",
                brand, model, notificationService.getServiceName());
    }
}
