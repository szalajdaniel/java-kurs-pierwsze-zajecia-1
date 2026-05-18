package main.java.lekcje.abstract_vehicle;

public class Car extends Vehicle {


    Car(String brand, String model, String notificationSericeName) {
        super(brand, model, notificationSericeName);
    }

    Car(String brand, String model) {
        super(brand, model);
    }

    @Override
    public void drive() {
        System.out.println("Jadę samochodem spalinowym");
    }
}
