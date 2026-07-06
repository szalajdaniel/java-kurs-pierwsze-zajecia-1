package park_flow;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;
public class MainParkFlow {
    /*Function<String, String> plateFormatter = new Function<String, String>() {
        @Override
        public String apply(String rawPlate) {
            return rawPlate.replace(" ", "").toUpperCase();
        }
    };
    */
    //CZĘŚĆ 1
    /*
    PYTANIE_1
    Lambda w javie zabrania zmieniania zwykłych zmiennych (tzw. "effectively final") z zewnatrz aby uniknać chaosu w pamieci komputera.
    Żeby to naprawić, zamiast zwykłej liczby trzeba użyć AtomicInteger.

    PYTANIE_2
    Zwykły String zmusza komputer do natychmiastowego wyprodukowania tekstu, nawet jak go nikt nie uzyje. Przy użyciu Supplier komputer
    ma przepis na tekst i dopiero w momencie gdy komputer potrzebuje tego teksu to go tworzy dzieki czemu chroni aplikacje przed spowolnieniem



     */

    //CZĘŚĆ 2
    //ZADANIE_1
    Function<String, String> plateFormatter = s -> s.replace(" ", "").toUpperCase();
    //ZADANIE_2
    //Function<String, String> plateFormatter2 = String::normalizePlate;
    public static void main(String[] args) {
    Predicate<String> isNullorBlank = s -> !s.isBlank();
    Predicate<String> hasValidPrefix = s -> s.startsWith("PARK-");
    Predicate<String> isInternalTest = s -> Objects.equals(s, "TEST-000");
    Predicate<String> isValidTicket = (isNullorBlank.and(hasValidPrefix)).or(isInternalTest);

    String ticket1 = "PARK-001";
    String ticket2 = "PAPA-43434";
        String ticket4 = "   ";
    String ticket3 = "TEST-000";

        System.out.println("Is the ticket correct?: " + isValidTicket.test(ticket1));
        System.out.println("Is the ticket correct?: " + isValidTicket.test(ticket2));
        System.out.println("Is the ticket correct?: " + isValidTicket.test(ticket3));
        System.out.println("Is the ticket correct?: " + isValidTicket.test(ticket4));


        Parking parking = new Parking();
        double basePrice = 10.0;
        System.out.println("=================CENNIK=================");
        System.out.println("Original basePrice: " + basePrice + "zł");

        System.out.println("MOTO: " + parking.calculateFee(basePrice, "MOTO") + " zł");
        System.out.println("CAR: " + parking.calculateFee(basePrice, "CAR") + " zł");
        System.out.println("BUS: " + parking.calculateFee(basePrice, "BUS") + " zł");
        System.out.println("TRUCK: " + parking.calculateFee(basePrice, "TRUCK") + " zł");
    }


}
