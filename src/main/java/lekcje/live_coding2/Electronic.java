package main.java.lekcje.live_coding2;

public class Electronic extends Product implements Shippable {
    private int warrantyMonths;

    public Electronic(String name, double basePrice) {
        super(name, basePrice);
    }

    public Electronic(Electronic other) {
        super(other);
    }

    @Override
    public double getBasePrice() {
        return super.getBasePrice();
    }

    @Override
    public double calculateFinalPrice() {
        return getBasePrice() * 1.10;
    }

    @Override
    public void ship(String address) {
        System.out.println("Shipping to " + address);
    }
}
