package main.java.lekcje.log_tracker.dispatch_table;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class DiscountSystem {
    Map<String, Function<Double, Double>> discountStrategies = new HashMap<>();

    public DiscountSystem() {
        discountStrategies.put("VIP", s -> s * 0.8);
        discountStrategies.put("STUDENT", s -> s - 15);
        discountStrategies.put("STANDARD", Function.identity());
    }

    public void calculatePrice(double basePrice, String discountCode) {
        Function<Double, Double> discountStrategy = discountStrategies.get(discountCode);
        if (discountStrategy == null) {
            System.err.println("No discount strategy found for discount code " + discountCode);
        } else {
            double price = discountStrategy.apply(basePrice);
            System.out.println("Price for discount code " + discountCode + " is " + price);
        }
    }
}
