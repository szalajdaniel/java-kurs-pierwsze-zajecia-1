package main.java.lekcje.PD6_walidator_formularza_rejestracji.exceptions;

public class WeakPasswordException extends RegistrationException {
    private final int score;
    private final String details;
    public WeakPasswordException(int score, String details) {
        super("Hasło za słabe: " + score + ", " + details);
        this.score = score;
        this.details = details;
    }

    public int getScore() {
        return score;
    }

    public String getDetails() {
        return details;
    }
}
