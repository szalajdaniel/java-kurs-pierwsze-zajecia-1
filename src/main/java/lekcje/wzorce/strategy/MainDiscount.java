package main.java.lekcje.wzorce.strategy;


public class MainDiscount {



    public static void main(String[] args) {
        DiscountStrategy studentDiscount = basePrice -> basePrice * 0.5;
        DiscountStrategy seniorDiscount = basePrice -> basePrice * 0.7;
        DiscountStrategy familyDiscount = basePrice -> basePrice - 10;
        DiscountStrategy noDiscount = basePrice -> basePrice;

        PriceCalculator priceCalculator = new PriceCalculator(studentDiscount);
        System.out.println(priceCalculator.calculate(50));
    }

}
