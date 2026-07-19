package main.java.lekcje.live_coding_3_stream.service;

import main.java.lekcje.live_coding_3_stream.model.Cinema;
import main.java.lekcje.live_coding_3_stream.model.Movie;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class MainStream {
    public static void main(String[] args) {
/*
        Stream<Movie> movieStream = moviesList.stream()
                .peek(m -> System.out.println("Sprawdzam: " + m.title()));

        boolean isAnyLong = movieStream.anyMatch(m -> m.durationMin() > 180);
        long totalMovies = movieStream.count();


        ODP:
        Wyjątek - IllegalStateException
        Jeśli użyjemy na danym obiekcie metody terminalnej(anyMatch) nie możemy na tym samym obiekcie ponownie użyć metody terminalnej(count)

*/

        List<Cinema> cinemas = List.of(
                new Cinema("Warszawa", List.of(
                        new Movie("Incepcja", "Sci-Fi", 148, 8.8),
                        new Movie("Shrek", "Animacja", 90, 7.9),
                        new Movie("Diuna", "Sci-Fi", 155, 8.0),
                        new Movie("Mroczny Rycerz", "Akcja", 152, 9.0),
                        new Movie("Joker", "Dramat", 122, 8.4)
                )),
                new Cinema("Kraków", List.of(
                        new Movie("Matrix", "Sci-Fi", 136, 8.7),
                        new Movie("Shrek", "Animacja", 90, 7.9),
                        new Movie("Toy Story", "Animacja", 81, 8.3),
                        new Movie("Pulp Fiction", "Kryminał", 154, 8.9),
                        new Movie("Forrest Gump", "Dramat", 142, 8.8),
                        new Movie("Gladiator", "Historyczny", 155, 8.5)
                )),
                new Cinema("Gdańsk", List.of(
                        new Movie("Król Lew", "Animacja", 88, 8.5),
                        new Movie("Avatar", "Sci-Fi", 162, 7.8),
                        new Movie("Titanic", "Romans", 194, 7.9),
                        new Movie("Terminator 2", "Akcja", 137, 8.6)
                )),
                new Cinema("Wrocław", List.of(
                        new Movie("Władca Pierścieni: Powrót Króla", "Fantasy", 201, 9.0),
                        new Movie("Shrek 2", "Animacja", 92, 7.7),
                        new Movie("Obcy - 8. pasażer Nostromo", "Sci-Fi", 117, 8.5),
                        new Movie("Top Gun: Maverick", "Akcja", 130, 8.3),
                        new Movie("Incepcja", "Sci-Fi", 148, 8.8)
                )),
                new Cinema("Poznań", List.of(
                        new Movie("Interstellar", "Sci-Fi", 169, 8.6),
                        new Movie("Kiler", "Komedia", 104, 7.8),
                        new Movie("Chłopaki nie płaczą", "Komedia", 96, 7.7),
                        new Movie("Spirited Away", "Animacja", 125, 8.6),
                        new Movie("Diuna: Część Druga", "Sci-Fi", 166, 8.8)
                )),
                new Cinema("Łódź", List.of(
                        new Movie("Skazani na Shawshank", "Dramat", 142, 9.3),
                        new Movie("Ojciec Chrzestny", "Kryminał", 175, 9.2),
                        new Movie("Spider-Man: Bez drogi do domu", "Akcja", 148, 8.2),
                        new Movie("Odlot", "Animacja", 96, 8.3)
                )),
                new Cinema("Katowice", List.of(
                        new Movie("Mad Max: Na drodze gniewu", "Akcja", 120, 8.1),
                        new Movie("Obecność", "Horror", 112, 7.5),
                        new Movie("Lśnienie", "Horror", 146, 8.4),
                        new Movie("Ciche Miejsce", "Horror", 90, 7.5),
                        new Movie("Matrix", "Sci-Fi", 136, 8.7)
                )),
                new Cinema("Szczecin", List.of(
                        new Movie("Avengers: Koniec gry", "Akcja", 181, 8.4),
                        new Movie("Wall-E", "Animacja", 98, 8.4),
                        new Movie("Szczęki", "Thriller", 124, 8.1),
                        new Movie("Truman Show", "Dramat", 103, 8.2)
                ))
        );
        System.out.println("------------------------ZADANIE 2-----------------------------");
        Set<String> uniqieCategories = cinemas.stream()
                .flatMap(cinema -> cinema.movies().stream())
                .map(Movie::category)
                .collect(Collectors.toSet());
        System.out.println("Unikalne kategorie: " + uniqieCategories);

        cinemas.stream()
                .flatMap(cinema -> cinema.movies().stream())
                .mapToDouble(Movie::rating)
                .average()
                .ifPresent(System.out::println);


        System.out.println("------------------------ZADANIE 3-----------------------------");
        List<Movie> allMovies = cinemas.stream()
                .flatMap(cinema -> cinema.movies().stream()).toList();

        Map<String, Long> genreReport = allMovies.stream()
                .collect(Collectors.groupingBy(Movie::category, Collectors.counting()));

        Map<Boolean, List<String>> hitCategorization = allMovies.stream()
                .collect(Collectors.partitioningBy(m -> m.rating() >= 8.0, Collectors.mapping(Movie::title, Collectors.toList())
                ));
        System.out.println("Kategorie: " + genreReport);
        System.out.println("Hity: " + hitCategorization.get(true));
        System.out.println("Pozostałe: " + hitCategorization.get(false));

        System.out.println("------------------------ZADANIE 4-----------------------------");

        allMovies.stream().
                sorted(Comparator.comparingInt(Movie::durationMin))
                .limit(3)
                .map(Movie::title)
                .reduce((title1, title2) -> title1 + " - " + title2)
                .ifPresent(System.out::println);




    }

}
