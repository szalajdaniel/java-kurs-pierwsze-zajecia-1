package main.java.lekcje.abstract_vehicle;

import java.util.ArrayList;

public class Main3 {
    public static void main(String[] args) {
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        vehicles.add(new Car("Audi", "Q3"));
        vehicles.add(new Tesla("X", "New-Service"));

        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
            vehicle.drive();
            if (vehicle instanceof Electric) {
                ((Electric) vehicle).charge();
            }
        }
    }
}
