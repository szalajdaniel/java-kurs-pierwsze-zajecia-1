package main.java.lekcje.adnotacje_bigdecimal_string;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BillSplitter {
    public static void main(String[] args) {

        BigDecimal accommodation = new BigDecimal("1540.85");
        BigDecimal fuel = new BigDecimal("423.10");
        BigDecimal groupDiscount = new BigDecimal("100.00");
        BigDecimal numberOfPeople = new BigDecimal("4");


        BigDecimal totalCost = accommodation.add(fuel);
        System.out.println("Łączny koszt przed rabatem: " + totalCost + " zł");

        BigDecimal costAfterDiscount = totalCost.subtract(groupDiscount);
        System.out.println("Koszt po uwzględnieniu rabatu: " + costAfterDiscount + " zł");

        BigDecimal costPerPerson = costAfterDiscount.divide(numberOfPeople, 2, RoundingMode.HALF_UP);

        System.out.println("Do zapłaty na osobę: " + costPerPerson + " zł");
    }
}