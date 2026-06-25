package main.java.lekcje.PD6_walidator_formularza_rejestracji;

import main.java.lekcje.PD6_walidator_formularza_rejestracji.exceptions.DuplicateEmailException;
import main.java.lekcje.PD6_walidator_formularza_rejestracji.exceptions.RegistrationException;
import main.java.lekcje.PD6_walidator_formularza_rejestracji.exceptions.ValidationException;
import main.java.lekcje.PD6_walidator_formularza_rejestracji.exceptions.WeakPasswordException;
import main.java.lekcje.PD6_walidator_formularza_rejestracji.service.UserRegistrationService;

import java.util.Scanner;

public class RegistrationApp {
    public static void main(String[] args) {
        UserRegistrationService service = new UserRegistrationService();
        System.out.println("Witaj w systemie rejestracji!");

        // try-with-resources automatycznie zamknie Scanner implementujący Closeable
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Podaj dane do rejestracji (lub wpisz 'exit' jako imię, by wyjść).");

                System.out.print("Imię: ");
                String name = scanner.nextLine().trim();
                if (name.equalsIgnoreCase("exit")) break;

                System.out.print("E-mail: ");
                String email = scanner.nextLine().trim();

                System.out.print("Hasło: ");
                String password = scanner.nextLine().trim();

                try {
                    service.registerUser(name, email, password);
                    System.out.println(">>> SUKCES: Użytkownik " + name + " został pomyślnie zarejestrowany!");
                    service.printDatabase();

                } catch (ValidationException e) {
                    System.out.println(">>> BŁĄD WALIDACJI: " + e.getMessage());
                    System.out.println("Spróbuj ponownie...\n");
                    // System naturalnie przejdzie do kolejnej iteracji pętli (retry)

                } catch (DuplicateEmailException e) {
                    System.out.println(">>> BŁĄD BAZY: " + e.getMessage());
                    System.out.println("Użyj innego adresu e-mail lub zaloguj się.\n");

                } catch (WeakPasswordException e) {
                    System.out.println(">>> BŁĄD BEZPIECZEŃSTWA: " + e.getMessage());
                    System.out.println("Wymyśl silniejsze hasło i spróbuj ponownie.\n");

                } catch (RegistrationException e) {
                    System.out.println(">>> NIEZNANY BŁĄD REJESTRACJI: " + e.getMessage() + "\n");
                }
            }
        }
        System.out.println("Zamykanie systemu...");
    }
}
