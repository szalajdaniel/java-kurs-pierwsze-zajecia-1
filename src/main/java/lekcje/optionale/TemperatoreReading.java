package main.java.lekcje.optionale;

import java.util.Optional;

public class TemperatoreReading {
   private Double value;
   public TemperatoreReading(Double value) {
       this.value = value;
   }
    Optional<Double> getValue(){
        return Optional.ofNullable(value);
    }
}
