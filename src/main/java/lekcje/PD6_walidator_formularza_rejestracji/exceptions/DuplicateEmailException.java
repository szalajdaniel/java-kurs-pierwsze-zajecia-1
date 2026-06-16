package main.java.lekcje.PD6_walidator_formularza_rejestracji.exceptions;

public class DuplicateEmailException extends RegistrationException {
    DuplicateEmailException() {
        super("Email juz istnieje");
    }
}
