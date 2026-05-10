package main.java.lekcje;

class Main {
    public static void main(String[] args) {

        int liczbaRzedow = 3;
        int liczbaMiejsc = 4;
        for (int i = 0; i < liczbaRzedow; i++) {
            System.out.println("");
            for (int k = 0; k < liczbaMiejsc; k++) {
                if ((i + k) % 2 == 0) {
                    System.out.print("[x]");
                } else {
                    System.out.print("[ ]");
                }
            }
        }


    }
}