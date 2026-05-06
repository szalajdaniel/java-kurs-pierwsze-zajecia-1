package main.java.lekcje.automatyczny_rozklad_jazdy;

import java.util.Scanner;

public class AutomatycznyRozkładJazdy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj dzień tygodnia:");
        int dzien = sc.nextInt();
        sc.close();
        String dniTygodnia = switch (dzien){
            case 1 -> "Poniedzialek";
            case 2 -> "Wtorek";
            case 3 -> "Sroda";
            case 4 -> "Czwartek";
            case 5 -> "Piatek";
            case 6 -> "Sobota";
            case 7 -> "Niedziela";
            default -> throw new IllegalArgumentException("Nieprawidłowy numer dnia tygodnia: " + dzien);
        };
        String informacjaDnia = switch (dniTygodnia){
            case "Poniedzialek", "Wtorek", "Sroda", "Czwartek", "Piatek" -> "Dzień roboczy";
            case "Sobota", "Niedziela" -> "Dzień wolny";
            default -> "Nieznana informacja o dniu";

        };
        String godzinaOdjazdu = switch (dniTygodnia){
            case "Poniedzialek", "Wtorek", "Sroda", "Czwartek", "Piatek" -> "05:30";
            case "Sobota" -> "07:00";
            case "Niedziela" -> "09:00";
            default -> "Nieznana godzina odjazdu";
        };

        System.out.println(dniTygodnia + ": " + informacjaDnia + ", odjazd autobusu jest o godzinie: " + godzinaOdjazdu);

    }
}
