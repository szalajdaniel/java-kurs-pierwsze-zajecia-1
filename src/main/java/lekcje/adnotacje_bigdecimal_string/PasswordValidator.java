package main.java.lekcje.adnotacje_bigdecimal_string;

public class PasswordValidator {

    public static void main(String[] args) {
        String testPassword1 = " MojeSuperTajneHaslo123! ";
        String testPassword2 = "slabehaslo";

        System.out.println("Test hasła 1:");
        System.out.println("Zwrócone hasło: '" + processPassword(testPassword1) + "'\n");

        System.out.println("Test hasła 2:");
        System.out.println("Zwrócone hasło: '" + processPassword(testPassword2) + "'");
    }

    public static String processPassword(String rawPassword) {
        if (rawPassword.startsWith(" ") || rawPassword.endsWith(" ")) {
            System.out.println("Hasło zawierało spacje na początku lub na końcu.");
        }

        String cleanPassword = rawPassword.strip();

        if (cleanPassword.length() < 8) {
            System.out.println("Hasło jest za krótkie. Musi mieć min. 8 znaków.");
        } else {
            System.out.println("Długość hasła jest prawidłowa.");
        }

        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (char c : cleanPassword.toCharArray()) {
            if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (!Character.isLetterOrDigit(c) && !Character.isWhitespace(c)) {
                hasSpecial = true;
            }

            if (hasDigit && hasSpecial) {
                break;
            }
        }

        if (hasDigit || hasSpecial) {
            System.out.println("Hasło zawiera cyfrę lub znak specjalny.");
        } else {
            System.out.println("Hasło musi zawierać co najmniej jedną cyfrę lub znak specjalny.");
        }

        return cleanPassword;
    }
}