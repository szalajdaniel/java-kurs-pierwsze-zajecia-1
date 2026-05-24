package main.java.lekcje.generycz_procesor_zadan;

public class StringPrinterTask implements Task<String> {
    @Override
    public void execute(String data) {
        if (data != null) {
            System.out.println(data.toUpperCase());
        } else {
            System.out.println("Brak danych");
        }
    }
}