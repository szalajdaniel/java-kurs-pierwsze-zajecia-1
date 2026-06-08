package main.java.lekcje.lambda;

import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

record User(String username, int age, boolean isActive, String email) {}

public class NotificationEngine {
    public static void main(String[] args) {
        // 1. Predicate - czy kwalifikuje się do powiadomienia
        Predicate<User> isEligible = user -> user.isActive() && user.age() >= 18;

        // 2. Function - wyciąga spersonalizowany komunikat
        Function<User, String> createMessage = user ->
                "Witaj " + user.username() + ", przygotowaliśmy dla Ciebie ofertę!";

        // 3. Consumer - symulacja wysyłki
        Consumer<String> sendNotification = message ->
                System.out.println("[WYSŁANO EMAIL]: " + message);

        // 4. Supplier - generator tokenów
        Supplier<String> tokenSupplier = () -> UUID.randomUUID().toString();

        // Przykładowy użytkownik
        User testUser = new User("JanKowalski", 25, true, "jan@example.com");

        // Logika przetwarzania
        if (isEligible.test(testUser)) {
            String message = createMessage.apply(testUser);
            String token = tokenSupplier.get();
            sendNotification.accept(message + " (Token: " + token + ")");
        }
    }
}