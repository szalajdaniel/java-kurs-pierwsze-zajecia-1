package main.java.lekcje.wyjatki;
import java.util.Objects;

public class ReservationService {

    public void createReservation(String clientName, int guestsCount, Table table) {

        // Guard Clauses (Fail-Fast)
        Objects.requireNonNull(clientName, "Nazwa klienta nie może być null!");

        if (guestsCount < 1 || guestsCount > 10) {
            throw new ReservationValidationException(
                    "Niepoprawna liczba gości",
                    "INVALID_GUESTS_COUNT"
            );
        }

        if (table == null) {
            throw new ReservationValidationException(
                    "Tabela nie może być null",
                    "NULL_TABLE_REFERENCE"
            );
        }

        try {
            table.book();
        } catch (TableAlreadyBookedException e) {
            throw new RestaurantException(
                    "Nie udało się utworzyć rezerwacji",
                    "RESERVATION_FAILED",
                    e
            );
        }
    }
}