package main.java.lekcje.aero_flow;

import main.java.lekcje.aero_flow.controller.FlightControl;
import main.java.lekcje.aero_flow.model.Aircraft;
import main.java.lekcje.aero_flow.model.Passport;

import java.util.HashSet;

public class MainAeroFlow {
    public static void main(String[] args) {
        //PYTANIE 1.1
        //Metoda jest niewydajna, ponieważ wywołanie ticketMap.get() w każdej iteracji wymusza ponownie oblicznie hasha
        //i odszukiwanie odpowiedniego kubełka. Uzycie entrySet() pozwala na pobranie gotowych kluczy-wartosci za jednym przejsciem.
        //PYTANIE 1.2
        //ZAGROZENIE 1 : Licznik sesji nie bedzie dobrze działał z powodu nakładających się na siebie modyfikacji
        //ZAGROZENIE 2 : Może wystąpić błąd przrz równoległe dodwanie elementów do zwyklej mapy
        //ROZWIAZANIE: Klasa....

        HashSet<Passport> passports = new HashSet<>();
        Passport passport1 = new Passport("EE99212", "Jan Kowalski");
        Passport passport2 = new Passport("EE99212", "Jan Milewski");
        passports.add(passport1);
        passports.add(passport2);
        for (Passport p : passports) {
            System.out.println(p);
        }
        System.out.println("Rozmiar kolekcji: " + passports.size());
        System.out.println("----------------------------------------------------------------");
        FlightControl flightControl = new FlightControl();

        flightControl.assignPassengerToGate("GATE-A17", "Jan Kowalski");
        flightControl.assignPassengerToGate("GATE-A17", "Jan Milewski");
        flightControl.assignPassengerToGate("GATE-B47", "Jan Bela");

        System.out.println("Passengers in GATE:");
        flightControl.getGateBoardingList().forEach((gate, passengers) -> System.out.println(gate + ": " + passengers));

        System.out.println("----------------------------------------------------------------");

        flightControl.registerDeparture(new Aircraft("Charters-707", 1));
        flightControl.registerDeparture(new Aircraft("Emergency-Med", 10));
        flightControl.registerDeparture(new Aircraft("Cargo-Flight", 4));
        flightControl.processTakeoffs();
    }
}
