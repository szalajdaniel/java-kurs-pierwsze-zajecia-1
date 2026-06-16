package main.java.lekcje.PD6_walidator_formularza_rejestracji.service;


import main.java.lekcje.PD6_walidator_formularza_rejestracji.PasswordStrength;
import main.java.lekcje.PD6_walidator_formularza_rejestracji.User;
import main.java.lekcje.PD6_walidator_formularza_rejestracji.exceptions.ValidationException;
import main.java.lekcje.PD6_walidator_formularza_rejestracji.exceptions.WeakPasswordException;

import java.util.HashMap;
import java.util.Map;

public class UserRegistrationService {
    private final Map<String, User> database = new HashMap<>();
    private final String regexEmail = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
    private final String regexName = "^[\\w.+\\-]+@[\\w\\-]+\\.[a-zA-Z]{2,}$";

    public void registerUser(String name, String email, String password) {
        if (name.length() < 2 && name.length() < 100)
            throw new ValidationException("Nieprawidłowa długość nazwy");
        if (!email.matches(regexEmail))
            throw new ValidationException("Nieprawidłowy adres e-mail");
        if (database.containsKey(email.toLowerCase())) {
            throw new ValidationException("Podany e-mail juz istnieje");
        }
        if (password == null) {
            throw new ValidationException("Hasło nie może być puste.");
        }

        if (validatePassword(password) == PasswordStrength.WEAK) {
            throw new WeakPasswordException(calculatePasswordScore(password), "Hasło za krótkie");
        }else System.out.println("Twoje hasło jest: "+ validatePassword(password).getDescription());
        String hashedPassword = "hashed_" + password;
        User newUser = new User(name, email.toLowerCase(), hashedPassword);
        database.put(newUser.email(), newUser);
    }

    public PasswordStrength validatePassword(String password) {
        int score = calculatePasswordScore(password);
        if (score < 4) return PasswordStrength.WEAK;
        if (score == 4 && password.length() < 12) return PasswordStrength.STRONG_WEAK;
        return PasswordStrength.STRONG;
    }

    private int calculatePasswordScore(String password) {
        int score = 0;
        if (password.length() >= 8) score++;
        if (password.matches(".*[A-Z].*")) score++;
        if (password.matches(".*\\d.*")) score++;
        if (password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*")) score++;
        return score;
    }

    public void printDatabase() {
        System.out.println("\n--- STAN BAZY DANYCH (" + database.size() + " użytkowników) ---");
        database.values().forEach(System.out::println);
        System.out.println("----------------------------------------\n");
    }
}
