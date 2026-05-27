package main.java.lekcje.live_coding2;

import java.util.ArrayList;

public class Warehouse<T extends Product> {
    private final ArrayList<T> products;
    public Warehouse() {
        products = new ArrayList<>();
    }
    public void addProduct(T product) {
        products.add(product);
    }
    public void showInventory(){
        for (T product : products) {
            System.out.println(product);
            System.out.println(product.calculateFinalPrice());
        }
    }

    public ArrayList<T> getProducts() {
        return products;
    }
}
