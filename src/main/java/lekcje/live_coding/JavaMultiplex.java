package main.java.lekcje.live_coding;

import java.util.Scanner;

public class JavaMultiplex {

    static void wyswietlSale(int[][] sala) {
        System.out.print("   ");
        for (int k = 0; k < sala.length; k++) {
            System.out.print(k + "  ");
        }
        System.out.println();
        for (int i = 0; i < sala.length; i++) {

            System.out.print(i + ".");
            for (int j = 0; j < sala[i].length; j++) {
                if (sala[i][j] == 1) {
                    System.out.print("[X]");
                } else
                    System.out.print("[ ]");

            }
            System.out.println();
        }
    }

    static void rezerwacjaMiejscaNaSali(int rzad, int kolumna, int[][] sala) {
       if (rzad < 0 || rzad >= sala.length || kolumna < 0 || kolumna >= sala[0].length) {
            System.out.println("Podane miejsce nie istanieje");
        } else if (sala[rzad][kolumna] == 1) {
            System.out.println("Podane miejsce jest juz zajete");
        } else {
            sala[rzad][kolumna] = 1;
            System.out.println("Miejsce: ["+rzad+"]["+kolumna+"] zostalo zarezerowane");
        }
    }

    static double obliczCeneGrupowa(int iloscBiletow, double cenaPodstawowa) {
    if (iloscBiletow <= 0) {
        return 0.0;
    }
    if (iloscBiletow == 1) {
        return cenaPodstawowa;
    }
    return cenaPodstawowa + obliczCeneGrupowa(iloscBiletow - 1, cenaPodstawowa * 0.95);
}



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean wyswietl = true;


        int[][] salaKinowa = new int[5][5];
        salaKinowa[0][0] = 1;
        salaKinowa[2][1] = 1;
        salaKinowa[0][1] = 1;

        while (wyswietl) {
            System.out.println("1. Pokaż salę | 2. Rezerwuj | 3. Cena grupowa | 0. Wyjdź");
            int opcja = sc.nextInt();
            sc.nextLine();
            System.out.println("Opcja: " + opcja);
            switch (opcja) {
                case 1 -> JavaMultiplex.wyswietlSale(salaKinowa);

                case 2 -> {
                    System.out.println("Podaj rząd:");
                    int rzad = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Podaj kolumna:");
                    int kolumna = sc.nextInt();
                    sc.nextLine();
                    JavaMultiplex.rezerwacjaMiejscaNaSali(rzad, kolumna, salaKinowa);
                }

                case 3 -> {
                    System.out.println("Ile biletów chcesz kupić?");
                    int iloscBiletow = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Podaj cenę biletu:");
                    double cenaPodstawowa = sc.nextDouble();
                    sc.nextLine();
                    System.out.printf("%.2f złotych", (JavaMultiplex.obliczCeneGrupowa(iloscBiletow, cenaPodstawowa)));
                    System.out.println();
                }
                case 0 -> {
                    System.out.println("Zamykanie programu");
                    wyswietl = false;
                }


                default -> System.out.println("Nieznana opcja");
            }

        }
        sc.close();


    }
}
