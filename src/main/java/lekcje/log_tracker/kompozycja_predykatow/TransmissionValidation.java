package main.java.lekcje.log_tracker.kompozycja_predykatow;

import java.util.function.Predicate;

public class TransmissionValidation {
    private String numberOfTransmission;
    Predicate<String> isNotNullOrEmpty = s -> s.isBlank();
    Predicate<String> hasValidPrefix = s -> !s.startsWith("EXP-");
    Predicate<String> hasCorrectLength = s -> s.length() == 10;
    Predicate<String> isValidTrackingCode =
            isNotNullOrEmpty.negate()
                    .and(hasValidPrefix.negate())
                    .and(hasCorrectLength);

    public TransmissionValidation(String numberOfTransmission) {
        this.numberOfTransmission = numberOfTransmission;
    }

    public boolean validateTransmission() {
        return isValidTrackingCode.test(numberOfTransmission);
    }
}
