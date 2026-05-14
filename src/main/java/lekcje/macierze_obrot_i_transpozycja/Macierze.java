package main.java.lekcje.macierze_obrot_i_transpozycja;

import java.util.Scanner;

public class Macierze {
    public static void main(String[] args) {

        //Tworzenie macierzy
        int[][] matrix = new int[3][3];
        Scanner sc = new Scanner(System.in);
        System.out.println("Wstaw liczby do macierzy:");
        for (int i = 0; i < 3; i++) {
            System.out.println(" ");
            for (int j = 0; j < 3; j++) {
                System.out.println("Podaj liczbe w miejscu macierzy " + "[" + i + "]" + "[" + j + "] :");
                matrix[i][j] = sc.nextInt();
                sc.nextLine();
            }
            //Wyświetlanie macierzy
            System.out.println();
            System.out.println("Macierz podstawowa:");
        }
        sc.close();
        for (int[] row : matrix) {
            System.out.println();
            for (int col : row) {
                System.out.print("[" + col + "]");
            }
        }

        //Transponowanie macierzy
        int[][] transpose_matrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                transpose_matrix[i][j] = matrix[j][i];
            }
        }

        //Wyświetlanie transponowanej macierzy
        System.out.println();
        System.out.println("Macierz transponowana:");

        for (int[] row : transpose_matrix) {
            System.out.println();
            for (int col : row) {
                System.out.print("[" + col + "]");
            }
        }
        //Tworzenie macierzy odwroconej o 90 stopni
        int[][] matrix_90 = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix_90.length; i++) {
            for (int j = 0; j < matrix_90[0].length; j++) {
                matrix_90[j][matrix_90[0].length - 1 - i] = matrix[i][j];
            }

        }
        //Wyświetlanie macierzy odwroconej o 90 stopni
        System.out.println();
        System.out.println("Macierz obrocona o 90 stopni:");

        for (int[] row : matrix_90) {
            System.out.println();
            for (int col : row) {
                System.out.print("[" + col + "]");
            }
        }
        //Suma liczb każdej kolumny
        System.out.println();
        for (int i = 0; i < matrix.length; i++) {
            int rowSum = 0;
            int colSum = 0;
            for (int j = 0; j < matrix.length; j++) {
                rowSum += matrix[i][j];
                colSum += matrix[j][i];
            }
            System.out.println("Suma wiersza " + (i + 1) + ": \t" + rowSum);
            System.out.println("Suma kolumny " + (i + 1) + ": \t" + colSum);
        }
        System.out.println();

        //Sprawdzanie czy macierz jest symetryczna
        boolean isSymmetric = true;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix_90.length; j++) {
                if (matrix[i][j] != matrix[j][i]) {
                    isSymmetric = false;
                    break;
                }
                }
        }
        if (!isSymmetric) {
            System.out.println("Macierz jest niesymetryczna");
        }
        else System.out.println("Macierz jest symetryczna");

    }
}
