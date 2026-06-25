package main.java.lekcje.PD6_walidator_formularza_rejestracji.exceptions;

public class ValidationException extends RegistrationException {
    private final String field;
    public ValidationException(String field) {
        super("Błąd walidacji: " + field);
        this.field = field;
    }

    public String getField() {
        return field;
    }
}
