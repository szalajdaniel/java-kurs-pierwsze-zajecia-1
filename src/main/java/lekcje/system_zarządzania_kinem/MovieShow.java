package main.java.lekcje.system_zarządzania_kinem;

public class MovieShow {
    private final String title;
    private final int durationMinutes;
    private final double ticketPrice;


    public MovieShow(String title, int durationMinutes, double ticketPrice) {
        this.title = title;
        this.durationMinutes = durationMinutes;
        this.ticketPrice = ticketPrice;
    }

    public MovieShow(String title, int durationMinutes) {
        this(title, durationMinutes, 25.0);
    }

    public static MovieShow createMarathon(String title) {
        return new MovieShow(title, 180, 40.0);
        
    }

    public String getTitle() {
        return title;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }
}

