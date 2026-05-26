package main.java.lekcje.live_coding2;

public abstract class Product {

    private final String ID;
    private String name;
    private double basePrice;
    private static int counter = 1;

    public Product(String name,double basePrice) {
        this.name = name;
        this.basePrice = basePrice;
        this.ID = "PROD-" + counter++;
    }
    public Product(Product other) {
        this.ID = "PROD-" + counter++;
        this.name = other.name;
        this.basePrice = other.basePrice;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public abstract double calculateFinalPrice();

    @Override
    public String toString() {
        return "Product{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", basePrice=" + basePrice +
                '}';
    }
}
