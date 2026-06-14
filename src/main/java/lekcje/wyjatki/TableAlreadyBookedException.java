package main.java.lekcje.wyjatki;

public class TableAlreadyBookedException extends RestaurantException {
    private final int tableNumber;

    public TableAlreadyBookedException(int tableNumber) {
        super("Stolik " + tableNumber + " jest już zajęty", "TABLE_ALREADY_BOOKED");
        this.tableNumber = tableNumber;
    }

    public int getTableNumber() {
        return tableNumber;
    }
}
