package main.java.lekcje.system_zarządzania_kinem;

public class Ticket {
    private final String ticketId;
    private final String movieTitle;
    private double price;

    private static int idCounter = 1000;
    private static double totalRevenue = 0.0;

    Ticket(String movieTitle, double price) {
        this.ticketId = "TICKET" + idCounter++;
        this.movieTitle = movieTitle;
        this.price = price;
        totalRevenue += price;
    }

    public static double getTotalRevenue() {
        return totalRevenue;
    }


    @Override
    public String toString() {
        return "\nBilet: " + ticketId + " | Film: " + movieTitle + " | Cena: " + price + " PLN";
    }
}
