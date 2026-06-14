package main.java.lekcje.wyjatki;

public class MainTable   {
    public static void main(String[] args) {

        ReservationService service = new ReservationService();
        Table table = new Table(1);

        try {
            service.createReservation("Jan Kowalski", 4, table);
            System.out.println("Rezerwacja zakończona sukcesem");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            service.createReservation("Jan Kowalski", -2, table);
        } catch (ReservationValidationException e) {
            System.out.println("Błąd walidacji: " + e.getMessage());
            System.out.println("Kod błędu: " + e.getErrorCode());
        }

        try {
            service.createReservation("Anna Nowak", 2, table);
        } catch (RestaurantException e) {
            System.out.println("Błąd: " + e.getMessage());
            System.out.println("Przyczyna: " + e.getCause());
        }
    }
}
