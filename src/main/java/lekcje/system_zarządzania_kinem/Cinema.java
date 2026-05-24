package main.java.lekcje.system_zarządzania_kinem;

import java.util.ArrayList;
import java.util.List;

public class Cinema {
    private List<Ticket> ticketList;
    private Manager manager;

    public Cinema(Manager manager) {
        this.manager = manager;
        this.ticketList = new ArrayList<>();
    }

    public void sellTicekt(Ticket ticket) {
        ticketList.add(ticket);
    }

    public static void main(String[] args) {
        Manager manager = new Manager("Marek", 8100.0, 610.0);
        Cinema cinema = new Cinema(manager);
        cinema.sellTicekt(new Ticket("Movietitle1", 50.0));
        cinema.sellTicekt(new Ticket("Movietitle2", 50.0));


        MovieShow marathon = MovieShow.createMarathon("Marathon");
        MovieShow marathon2 = MovieShow.createMarathon("Marathon2");
        cinema.sellTicekt(new Ticket(marathon.getTitle(), marathon.getTicketPrice()));
        cinema.sellTicekt(new Ticket(marathon2.getTitle(), marathon2.getTicketPrice()));

        System.out.println("\n--- PODSUMOWANIE FINANSOWE KINA ---");
        System.out.println("Manager obiektu: " + cinema.manager.getName());
        System.out.println("Pensja managera (podstawa + bonus): " + cinema.manager.calculateSalary() + " PLN");
        System.out.println("Liczba sprzedanych biletów: " + cinema.ticketList.size());
        System.out.println("Lista biletów: " + cinema.ticketList.toString());
        System.out.println("Łączny przychód ze sprzedaży: " + Ticket.getTotalRevenue() + " PLN");

    }
}
