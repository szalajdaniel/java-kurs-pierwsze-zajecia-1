package main.java.lekcje.wzorce.observer;

public record TicketBookedEvent(String ticketId, String customerEmail) implements Event {
    public String type(){
        return "TICKET_BOOKED";
    }
}
