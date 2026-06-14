package main.java.lekcje.wyjatki;

public class ReservationValidationException extends RestaurantException {
    public ReservationValidationException(String message, String errorCode) {
        super(message, errorCode);
    }
}