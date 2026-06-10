package main.java.lekcje.optionale;

public class MainOptional {
    public static void main(String[] args) {
        TemperatoreReading temperatoreReading = new TemperatoreReading(-11.00);
        Sensor sensor = new Sensor(temperatoreReading);
        Room room = new Room(sensor);
        SmartHomeService.processRoomTemperature(room);
    }
}
