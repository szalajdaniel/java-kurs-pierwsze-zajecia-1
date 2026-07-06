package main.java.lekcje.log_tracker.kompozycja_predykatow;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LogMain {
    public static void main(String[] args) {
        List<String> logs = new ArrayList<>(List.of("  error: db down  ", "  info: user logged  "));

        logs.sort(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });
        //Zadanie1
        logs.sort((s1, s2) -> s1.compareTo(s2));
        //Zadanie2
        logs.sort(String::compareTo); //do metody instancyjnej na typie

        List<String> codes = List.of(
                "TRK-123456",
                "EXP-123456",
                "          ",
                "TRK-123",
                "1234567890"
        );
        codes.forEach(code -> {
            TransmissionValidation validation = new TransmissionValidation(code);
            boolean result = validation.validateTransmission();
            System.out.println("Kod: [" + code + "] -> " + (result ? "ZAAKCEPTOWANY" : "ODRZUCONY"));
        });
    }
}
