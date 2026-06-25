package main.java.lekcje.ewolucja_lambdy;

import java.util.function.Function;

public class CyberSignalApp {
    public static void main(String[] args) {
        String text = "   [ALERT]: OMNI_CORP_IS_WATCHING   ";

        SignalStripper stripper = new SignalStripper();

        Function<String, String> step2 = new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s.strip();
            }
        };

        Function<String, String> step3 = (String s) -> {
            return s.strip();
        };

        Function<String, String> step4 = s -> s.strip();


        Function<String, String> step5 = String::strip;


        System.out.println(stripper.apply(text));
        System.out.println(step2.apply(text));
        System.out.println(step3.apply(text));
        System.out.println(step4.apply(text));
        System.out.println(step5.apply(text));

    }

    // Wydajność wszystkich kroków jest mniej więcej taka sama, a krok piąty jest najlepszy pod kątem wizualnym dla programisty
}
