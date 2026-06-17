package main.java.lekcje.pulapka_treeset;

import java.util.Comparator;
import java.util.TreeSet;

public class MainTreeset {
    public static void main(String[] args) {
        TreeSet<Player> players = new TreeSet<>(Comparator.comparingInt(Player::getScore).reversed().thenComparing(Player::getName));

        players.add(new Player("Kamil", 1500));
        players.add(new Player("Andrzej", 1200));
        players.add(new Player("Mariola", 1200));
        players.add(new Player("Sonia", 900));
        System.out.println(players);

    }
}
//ODPOWIEDZ NA PYTANIE:
//Różnica polega na tym, że HashSet weryfikuje unikalność obiektów za pomocą metod hashCode() i equals() (które domyślnie
// sprawdzają ich fizyczny adres w pamięci), podczas gdy TreeSet uznaje za duplikat wszystko, dla czego użyty komparator
// zwróci wartość zero, całkowicie ignorując tożsamość obiektu.