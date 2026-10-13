package main.java.lekcje.wzorce.observer;

import main.java.lekcje.wzorce.strategy.PriceCalculator;

public class MainObserver {
    public static void main(String[] args) {
        EventBus bus = new EventBus();

        bus.subscribe("TICKET_BOOKED", event -> {
            if (event instanceof TicketBookedEvent e) {
                System.out.printf("Zaksięgowano bilet: %s%n", e.ticketId());
            }
        });

        bus.subscribe("TICKET_BOOKED", event -> {
            throw new RuntimeException("SMS Gateway Offline!");
        });

        bus.subscribe("TICKET_BOOKED", event -> {
            if (event instanceof TicketBookedEvent e) {
                System.out.printf("Wysłano email na: %s%n", e.customerEmail());
            }
        });

        bus.publish(new TicketBookedEvent("TICKET-001", "kowalski@o2.pl"));

    }

}
