package main.java.lekcje.kalkulator;
import java.util.Scanner;

public class Kalkulator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Witaj w kalkulatorze");
        System.out.println("Podaj wage w kilogramach:");
        double weightKg = sc.nextDouble();
        System.out.println("Podaj wzrost w centymetrach");
        double heightCm = sc.nextDouble();
        if(heightCm<30 || heightCm>240) {
            System.out.println("Nieprawidłowy wzrost, podaj ponowanie:");
            heightCm = sc.nextDouble();
        }
        else System.out.println("Wzrost poprawny");
        double BMI = weightKg / (Math.pow(heightCm / 100, 2));
        String sformatowaneBMI = String.format("%.2f", BMI);
        System.out.println("BMI is " + sformatowaneBMI);
        if (BMI < 18.5) {
            System.out.println("Niedowaga");
        } else if (BMI >= 18.5 && BMI <= 24.9) {
            System.out.println("Dobra waga");
        } else System.out.println("Nadwaga");

    }
}
