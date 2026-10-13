package main.java.lekcje.wzorce.strategy;
@FunctionalInterface
public interface DiscountStrategy {
    double apply(double basePrice);
}
