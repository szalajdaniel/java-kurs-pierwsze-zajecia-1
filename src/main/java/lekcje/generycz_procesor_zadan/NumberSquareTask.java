package main.java.lekcje.generycz_procesor_zadan;

public class NumberSquareTask implements Task<Integer> {
    @Override
    public void execute(Integer data) {
        if (data != null) {
            int result = data * data;
            System.out.println("Wynik: " + result);
        } else {
            System.out.println("Brak danych");
        }
    }
}
