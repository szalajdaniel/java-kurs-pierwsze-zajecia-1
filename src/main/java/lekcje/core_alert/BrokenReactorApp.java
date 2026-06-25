package main.java.lekcje.core_alert;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Supplier;

class ReactorDiagnostics {
    public static String triggerEmergencyCooling(String coolingSystemName) {
        System.out.println("[KRYTYCZNE] !!! URUCHAMIAM SYSTEM: " + coolingSystemName + " !!!");
        return "SYSTEM_ACTIVE";
    }
}

class AlertService {
    public void logAlert(String message) {
        System.out.println("[DIAGNOSTYKA] Zapisano alert: " + message);
    }
}

public class BrokenReactorApp {
    public static void main(String[] args) {
        double currentCoreTemp = 30.0; // Bezpieczna temperatura reaktora
        System.out.println("Status reaktora: BEZPIECZNY. Temperatura: " + currentCoreTemp + "C");

        // === ANTYWZORZEC 1 ===
        // Rejestracja procedury awaryjnej (chcemy, by odpaliła się TYLKO w razie awarii)
        Supplier<String> emergencyAction = () -> ReactorDiagnostics.triggerEmergencyCooling("WaterCooling");

        if (currentCoreTemp > 500.0) {
            System.out.println("!!! ALARM !!!");
            emergencyAction.get();
        }

        // === ANTYWZORZEC 2 ===
        // Chcemy zliczyć ile odczytów przekroczyło normę ostrzegawczą (> 25.0)
        List<Double> temperatureHistory = List.of(26.4, 24.1, 28.9, 21.0, 31.5);
        AtomicInteger warningCounter = new AtomicInteger(0);

        temperatureHistory.forEach(temp -> {
            if (temp > 25.0) {
                // Czy to podejście jest bezpieczne w systemach produkcyjnych?
                warningCounter.incrementAndGet();
            }
        });
        System.out.println("Liczba odczytów ostrzegawczych: " + warningCounter.get());

        // === ANTYWZORZEC 3 ===
        // Wiązanie referencji do serwisu logowania
        AlertService alertService = null; // Serwis nie został jeszcze zainicjalizowany!

        // Definiujemy obsługę alertów za pomocą Method Reference
        Consumer<String> criticalAlertHandler = messages -> {
            if (alertService == null) {
                alertService.logAlert(messages);
            }
            else System.out.println("[ALERT] Nie można zapisać komunikatu. Serwis logowania jest niedostępny!");
        };

        // ... gdzieś dalej w kodzie reaktor zgłasza awarię ...
        try {
            criticalAlertHandler.accept("Przekroczono ciśnienie w komorze!");
        } catch (NullPointerException e) {
            System.err.println("CRASH! System monitorowania padł z powodu NPE!");
        }
    }
}
//PYTANIE 1. Program od razu wykonuje tę metodę, bo brakuje zapisu ze strzałką () ->, który kazałby mu poczekać na faktyczną awarię.
//
//PYTANIE 2. W Javie taki blok kodu nie pozwala na modyfikowanie zwykłych zmiennych, więc autor "oszukał" system, wrzucając liczbę
// do tablicy, dzięki czemu zmienia tylko to, co jest w jej środku.
//
//PYTANIE 3. Błąd wyskoczy jednak od razu w linii 37, ponieważ użycie skróconego zapisu z dwukropkami (::) zmusza program
// do natychmiastowego sprawdzenia, czy podany obiekt w ogóle istnieje.