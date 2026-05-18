package main.java.lekcje.klasy;

public class Product {
    private final String name;
    private final int price;
    private final String category;
    Product(String name, int price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }
    String getDescription(){
        return name + " " + price + " " + category;
    }
}
