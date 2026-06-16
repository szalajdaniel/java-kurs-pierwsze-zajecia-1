package main.java.lekcje.PD6_walidator_formularza_rejestracji.exceptions;

public class RegistrationException extends RuntimeException {

    RegistrationException(String message) {
        super(message);
    }
}
