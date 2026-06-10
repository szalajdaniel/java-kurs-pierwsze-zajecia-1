package main.java.lekcje.optionale;

import java.util.Optional;

public class SmartHomeService {
    public static void processRoomTemperature(Room room){
        Optional.ofNullable(room)
                .flatMap(Room::getSensor)
                .flatMap(Sensor::getReading)
                .flatMap(TemperatoreReading::getValue)
                .filter(b -> b > -10 && b < 50)
                .ifPresentOrElse(
                        b -> System.out.println("Sukces:" + b),
                        () -> {throw new IllegalArgumentException("Uszkodzony czujnik");}
        );

    }
}
