package main.java.lekcje.wyjatki;

public class RestaurantException extends RuntimeException {
    private final String errorCode;

    public RestaurantException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public RestaurantException(String message, String errorCode, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}