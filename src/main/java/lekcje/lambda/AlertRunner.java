package main.java.lekcje.lambda;

public class AlertRunner {
    public static void main(String[] args) {

        AlertTransformer transformer = (message, prefix) -> (prefix + " " + message).toUpperCase().trim();

        String result = transformer.transform("  awaria serwera aplikacji  ", "[ALERT]");
        System.out.println(result);
    }
}