package main.java.lekcje.wzorce.strategy;

import java.util.Objects;

public class PriceCalculator {
    private DiscountStrategy discountStrategy;

    PriceCalculator(DiscountStrategy discountStrategy){
        this.discountStrategy = Objects.requireNonNull(discountStrategy,"Strategia nie może być pusta");
    }

    public double calculate (double price){
        return discountStrategy.apply(price);
    }

}
