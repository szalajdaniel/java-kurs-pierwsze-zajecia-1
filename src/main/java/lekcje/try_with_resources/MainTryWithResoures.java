package main.java.lekcje.try_with_resources;

public class MainTryWithResoures {
    public static void main(String[] args) {

        String[] testValues = {"8080", "tekst", "999999", null};

        for (String testValue : testValues) {
            System.out.println("\n--- Test dla wartości: " + testValue + " ---");

            try (ConfigFileConnection connection = new ConfigFileConnection()) {

                int validPort = ConfigFileConnection.parseAndValidatePort(testValue);
                System.out.println("[SUKCES] Zwalidowano poprawnie port: " + validPort);

            } catch (IllegalArgumentException e) {
                System.out.println("[BŁĄD] " + e.getMessage());
            }
        }
    }
}
