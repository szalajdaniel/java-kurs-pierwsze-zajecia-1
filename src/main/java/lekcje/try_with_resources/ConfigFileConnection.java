package main.java.lekcje.try_with_resources;

public class ConfigFileConnection implements AutoCloseable {
    public ConfigFileConnection() {
        System.out.println("[SYSTEM] Otwarto strumień pliku konfiguracyjnego.");
    }
    @Override
    public void close(){
        System.out.println("[SYSTEM] Strumień pliku został automatycznie zamknięty");
    }
    public static int parseAndValidatePort(String rawPort) {
        int rawPortTemp;
        if (rawPort == null || rawPort.isBlank()) {
            throw new IllegalArgumentException("Port nie może być pusty!");
        }
        try {
            rawPortTemp = Integer.parseInt(rawPort);
            if(rawPortTemp < 1024 || rawPortTemp > 65535) {
                throw new IllegalArgumentException("Port poza bezpiecznym zakresem (1024-65535)!");
            }
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException("Port musi być liczbą! Otrzymano: X");
        }
        return rawPortTemp;
    }

}
