package main.java.lekcje.abstract_vehicle;

public class Tesla extends Vehicle implements Electric {
    public Tesla(String model, String notificationServiceName) {
        super("Tesla", model, notificationServiceName);
    }

    public Tesla(String model) {
        super("Tesla", model);
    }

    @Override
    public void drive() {
        System.out.println("Jadę samochodem elektryczym");

    }

    @Override
    public void charge() {
        System.out.println("Ładowanie akumulatorów Tesli...");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
