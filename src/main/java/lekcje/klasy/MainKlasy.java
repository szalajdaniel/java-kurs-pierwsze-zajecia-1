package main.java.lekcje.klasy;

import java.time.LocalDate;
import java.util.ArrayList;

public class MainKlasy {
    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new FoodProduct("Jablko", 2,"Owoce", LocalDate.of(2028, 1, 2)));
        products.add(new Electronics("Samsung",2200,"Telewizor",24 ));
        products.add(new Product("Produkt",2500,"Produkty"));
        for (Product product : products) {
            System.out.println(product.getDescription());
        }
    }

}
