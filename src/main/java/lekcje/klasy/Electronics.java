package main.java.lekcje.klasy;

public class Electronics extends Product {
private final int warranty;
    Electronics(String name, int price, String category, int warranty) {
        super(name, price, category);
        this.warranty = warranty;
    }

    @Override
    String getDescription() {
        return super.getDescription() + " " + warranty;
    }
}
