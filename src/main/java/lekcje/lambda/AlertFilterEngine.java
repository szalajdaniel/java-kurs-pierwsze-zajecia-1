package main.java.lekcje.lambda;

import java.util.List;
import java.util.function.Predicate;

record SystemAlert(String serviceName, int severityLevel, String logMessage) {}

public class AlertFilterEngine {
    public static void main(String[] args) {

        Predicate<SystemAlert> isCritical = alert -> alert.severityLevel() >= 5;

        Predicate<SystemAlert> isDatabaseAlert = alert -> "DATABASE".equals(alert.serviceName());

        Predicate<SystemAlert> containsError = alert ->
                alert.logMessage() != null && alert.logMessage().contains("ERROR");


        Predicate<SystemAlert> requiresImmediateAction = isCritical
                .and(containsError)
                .or(isDatabaseAlert);

        // Testowanie systemu
        List<SystemAlert> alerts = List.of(
                new SystemAlert("PAYMENT", 5, "Connection timeout ERROR"),
                new SystemAlert("PAYMENT", 5, "High latency warning"),
                new SystemAlert("DATABASE", 2, "Normal backup started"),
                new SystemAlert("AUTH", 1, "User login ERROR")
        );

        System.out.println("--- Alerty Wymagające Akcji ---");
        alerts.stream()
                .filter(requiresImmediateAction)
                .forEach(alert -> System.out.println("Akcja dla: " + alert));
    }
}