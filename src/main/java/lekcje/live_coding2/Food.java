package main.java.lekcje.live_coding2;

public class Food extends Product {
    private String expirationDate;

    public Food(String name, double basePrice) {
        super(name, basePrice);
    }


    @Override
    public double getBasePrice() {
        return super.getBasePrice();
    }

    @Override
    public double calculateFinalPrice() {
        return getBasePrice() * 0.8;
    }

}
