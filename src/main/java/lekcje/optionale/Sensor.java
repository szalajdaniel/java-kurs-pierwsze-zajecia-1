package main.java.lekcje.optionale;

import java.util.Optional;

public class Sensor {
     private TemperatoreReading reading;
     public Sensor(TemperatoreReading reading) {
         this.reading = reading;
     }
     Optional<TemperatoreReading> getReading(){
         return Optional.ofNullable(reading);
     }

}
