package main.java.lekcje.PD6_walidator_formularza_rejestracji;

public enum PasswordStrength {
    WEAK("Słabe"),
    STRONG_WEAK("Średnie"),
    STRONG("Silne");
    private final String description;

    PasswordStrength(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
