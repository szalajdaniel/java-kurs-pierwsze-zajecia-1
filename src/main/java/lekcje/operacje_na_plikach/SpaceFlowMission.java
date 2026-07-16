package main.java.lekcje.operacje_na_plikach;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class SpaceFlowMission {

    public static void main(String[] args) {
        try {
            System.out.println("=== ZADANIE 1 ===");
            executeTask1();

            System.out.println("\n=== ZADANIE 2 ===");
            prepareTelemetryData();
            executeTask2();

        } catch (IOException e) {
            System.err.println("Wystąpił błąd wejścia/wyjścia: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void executeTask1() throws IOException {
        Path missionControlPath = Path.of("mission_control");
        Path rosterPath = missionControlPath.resolve("crew_roster.txt");

        if (Files.notExists(missionControlPath)) {
            Files.createDirectory(missionControlPath);
            System.out.println("Utworzono katalog: " + missionControlPath.toAbsolutePath());
        }

        List<String> astronauts = List.of(
                "Jan Twardowski",
                "Anna Nowak",
                "Ellen Ripley",
                "Luke Skywalker",
                "Han Solo",
                "Sarah Connor"
        );

        Files.write(rosterPath, astronauts);

        System.out.println("Zatwierdzona załoga:");
        Files.readAllLines(rosterPath).stream()
                .filter(name -> {
                    String[] parts = name.split(" ");
                    String lastName = parts[parts.length - 1];
                    return lastName.length() > 5;
                })
                .map(name -> "ZATWIERDZONY " + name)
                .forEach(System.out::println);
    }

    private static void prepareTelemetryData() throws IOException {
        Path logPath = Path.of("telemetry.log");
        String testData = """
                2026-07-14T18:00;ENGINE_TEMP;OK;85.5
                2026-07-14T18:05;HULL_PRESSURE;WARNING;102.1
                2026-07-14T18:10;ENGINE_TEMP;CRITICAL;120.5
                2026-07-14T18:15;SOLAR_PANEL;OK;99.0
                2026-07-14T18:20;OXYGEN_LEVEL;CRITICAL;15.2
                """;
        Files.writeString(logPath, testData);
    }

    private static void executeTask2() throws IOException {
        Path inputLogPath = Path.of("telemetry.log");
        Path outputAlertsPath = Path.of("critical_alerts.txt");

        try (Stream<String> lines = Files.lines(inputLogPath);
             BufferedWriter writer = Files.newBufferedWriter(outputAlertsPath)) {

            lines.filter(line -> line.contains("CRITICAL"))
                    .map(line -> line.split(";")[1])
                    .forEach(system -> {
                        try {
                            writer.write(system);
                            writer.newLine();
                        } catch (IOException e) {
                            throw new UncheckedIOException("Błąd podczas zapisu systemu: " + system, e);
                        }
                    });

            System.out.println("Zakończono analizę telemetrii. Wyniki zapisano w: " + outputAlertsPath);
        }
    }
}