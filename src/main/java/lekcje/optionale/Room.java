package main.java.lekcje.optionale;

import java.util.Optional;

public class Room {
    String name;
    Sensor sensor;
    public Room(Sensor sensor) {
        this.sensor = sensor;
    }
    Optional<Sensor> getSensor(){
        return Optional.ofNullable(sensor);
    };
}
