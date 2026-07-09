package main.java.lekcje.zaawansowane_strumienie.service;

import main.java.lekcje.zaawansowane_strumienie.model.Product;

import java.util.DoubleSummaryStatistics;
import java.util.List;

public class ShopStatistics {
    public static void main(String[] args) {
        List<Product> products = List.of(
                new Product("Myszka", 150.0, true),
                new Product("Klawiatura", 350.0, false),
                new Product("Laptop Premium", 8500.0, true),
                new Product("Monitor", 1200.0, true),
                new Product("Podkładka", 45.0, true)
        );


        DoubleSummaryStatistics stats = products.stream()
                .mapToDouble(Product::price)
                .summaryStatistics();

        System.out.println("Najtańszy produkt (cena): " + stats.getMin() + " zł");
        System.out.println("Najdroższy produkt (cena): " + stats.getMax() + " zł");
        System.out.println("Średnia cena w sklepie: " + stats.getAverage() + " zł");

        boolean allInStock = products.stream()
                .allMatch(Product::inStock);
        System.out.println("Czy wszystkie produkty są w magazynie? " + allInStock);

        boolean hasPremium = products.stream()
                .anyMatch(p -> p.price() > 1000.0);
        System.out.println("Czy mamy w ofercie towary premium? " + hasPremium);

    }
}
