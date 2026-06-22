package main.java.lekcje.java_collections_framework;
import java.util.Comparator;
import java.util.TreeSet;
//ZADANIE 1.1
//wybiorę ArrayList, ponieważ administrator odczytuje logi po indeksie, co ta struktura realizuje w natychmiastowym
// czasie $O(1)$, podczas gdy LinkedList wymagałaby sekwencyjnego przeszukiwania o złożoności $O(n)$. Dodatkowo ArrayList
// bardzo sprawnie przyjmuje nowe wpisy na koniec listy (zamortyzowane $O(1)$) i zużywa znacznie mniej pamięci niż LinkedList,
// która przy milionach logów dziennie generowałaby ogromny narzut na obiekty węzłów.
//ZADANIE 1.2
//Wynik wynosił 1 dlatego że komparator sprawdzał obiekty tylko po cenie produktu i dlatego ze była taka sama to uznawał ją jako duplikat.
record Product(String name, double price) {}

public class MainJavaColletions {
    public static void main(String[] args) {
        // Poprawiony komparator: najpierw cena, potem nazwa
        TreeSet<Product> products = new TreeSet<>(
                Comparator.comparingDouble(Product::price)
                        .thenComparing(Product::name)
        );
        products.add(new Product("Myszka", 150.00));
        products.add(new Product("Klawiatura", 150.00));

        System.out.println("Rozmiar: " + products.size()); // Teraz wypisze: 2
    }
}