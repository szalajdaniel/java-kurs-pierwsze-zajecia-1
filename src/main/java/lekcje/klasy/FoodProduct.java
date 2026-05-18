package main.java.lekcje.klasy;

import java.time.LocalDate;


public class FoodProduct extends Product{
    private final LocalDate expiryDate;


    FoodProduct(String name, int price, String category, LocalDate expiryDate) {
        super(name, price, category);
        this.expiryDate = expiryDate;
    }

    @Override
    String getDescription() {
        return super.getDescription() + " " + expiryDate;
    }
}
