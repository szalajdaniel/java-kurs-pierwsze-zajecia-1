package main.java.lekcje.zaawansowane_lambdy_i_strategie;

import main.java.lekcje.zaawansowane_lambdy_i_strategie.model.Event;
import main.java.lekcje.zaawansowane_lambdy_i_strategie.model.Message;
import main.java.lekcje.zaawansowane_lambdy_i_strategie.service.EventProcessor;
import main.java.lekcje.zaawansowane_lambdy_i_strategie.service.MessageDispatcher;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class MainLamda {
    public static void main(String[] args) {
        System.out.println("--- START ZADANIA 1 ---");
        testTask1();

        System.out.println("\n--- START ZADANIA 2 ---");
        testTask2();
    }

    private static void testTask1() {
        List<Message> messages = List.of(
                new Message("MSG-001", "Spotkanie o swicie", 3),
                new Message("MSG-002", "Atakujemy flanke", 8),
                new Message("MSG-003", "Brak zaopatrzenia", 6),
                new Message("MSG-004", "Zwiadowca zlapany", 10)
        );

        MessageDispatcher dispatcher = new MessageDispatcher();

        EncryptionStrategy reverseAndUpper = text ->
                new StringBuilder(text).reverse().toString().toUpperCase();

        EncryptionStrategy leetSpeak = text -> text
                .replace('a', '4')
                .replace('A', '4')
                .replace('e', '3')
                .replace('E', '3')
                .replace('i', '1')
                .replace('I', '1')
                .replace('o', '0')
                .replace('O', '0');

        EncryptionStrategy obfuscation = text -> {
            if (text == null || text.length() <= 2) return text;
            return text.charAt(0) + "***" + text.charAt(text.length() - 1);
        };

        Consumer<String> consoleSender = System.out::println;

        System.out.println("1. Tylko SecurityLevel > 5 (Odwrócenie i Wersaliki):");
        dispatcher.dispatch(messages, reverseAndUpper, m -> m.securityLevel() > 5, consoleSender);

        System.out.println("\n2. Tylko SecurityLevel >= 8 (Leet Speak):");
        dispatcher.dispatch(messages, leetSpeak, m -> m.securityLevel() >= 8, consoleSender);

        System.out.println("\n3. Wszystkie wiadomości (Ukrycie środka):");
        dispatcher.dispatch(messages, obfuscation, m -> true, consoleSender);
    }

    private static void testTask2() {
        List<Event> events = List.of(
                new Event("EVT-10", "NETWORK_DOWN", "Utrata połączenia z bazą", true),
                new Event("EVT-11", "USER_LOGIN", "Udane logowanie administratora", false),
                new Event("EVT-12", "DB_TIMEOUT", "Zbyt długi czas odpowiedzi bazy", true),
                new Event("EVT-13", "SYSTEM_UPDATE", "Rozpoczęto aktualizację paczek", false)
        );

        EventProcessor processor = new EventProcessor();

        List<Predicate<Event>> criticalDbFilters = new ArrayList<>();
        criticalDbFilters.add(Event::isCritical);
        criticalDbFilters.add(e -> e.description().toLowerCase().contains("baz")); // szukamy bazy w opisie

        List<Predicate<Event>> allFilters = List.of(e -> true);

        Function<Event, String> jsonFormatter = e ->
                String.format("{ \"id\": \"%s\", \"type\": \"%s\", \"critical\": %b }", e.id(), e.type(), e.isCritical());

        Function<Event, String> alertFormatter = e ->
                String.format("!!! ALERT [%s] !!! -> %s", e.type(), e.description().toUpperCase());

        Consumer<String> consoleOutput = System.out::println;

        System.out.println("1. Krytyczne błędy bazy danych (JSON Formatter):");
        processor.process(events, criticalDbFilters, jsonFormatter, consoleOutput);

        System.out.println("\n2. Wszystkie zdarzenia (Alert Formatter):");
        processor.process(events, allFilters, alertFormatter, consoleOutput);
    }
}
/*
Pytanie 1: Dlaczego .and() jest lepsze niż && w jednym wielkim bloku?
Zamiast budować jeden wielki i skomplikowany warunek na sztywno, .and() pozwala nam łączyć małe, proste reguły w
zależności od potrzeb. Dzięki temu możemy łatwo testować każdą regułę osobno i dodawać nowe reguły w trakcie
działania programu.

Pytanie 2: Dlaczego używamy własnej nazwy (interfejsu) zamiast ogólnej z systemu?
Własna nazwa (np. EncryptionStrategy) od razu mówi, że ten element służy tylko i wyłącznie do szyfrowania
 wiadomości. To tak, jakby na pudełku napisać "Klucze do kół", zamiast ogólnego "Narzędzia", co ułatwia pracę całemu
  zespołowi i zapobiega pomyłkom.
 */