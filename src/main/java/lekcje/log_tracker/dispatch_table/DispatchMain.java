package main.java.lekcje.log_tracker.dispatch_table;

public class DispatchMain {
    public static void main(String[] args) {
        DiscountSystem system = new DiscountSystem();

        system.calculatePrice(100.0, "VIP");
        system.calculatePrice(100.0, "STANDARD");
        system.calculatePrice(100.0, "NIEZNANY_KOD");
        system.calculatePrice(100.0, "STUDENT");
        system.calculatePrice(100.0, null);


    }

}
