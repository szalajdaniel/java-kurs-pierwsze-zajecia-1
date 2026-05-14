package main.java.lekcje.robot_menager;

public class RobotTask {

    // 1. Przeciążanie - Metoda do ładowania o konkretną liczbę jednostek
    public static int charge(int currentEnergy, int energyToAdd) {
        return Math.min(currentEnergy + energyToAdd, 100);
    }

    // 2. Przeciążanie - Metoda do ładowania "do pełna" (użyj boolean fullCharge)
    public static int charge(int currentEnergy, boolean fullCharge) {
        if (fullCharge) {
            return 100;
        }
        return currentEnergy;
    }


    // 3. Rekurencja - Obliczanie zużycia energii na powrót (Suma liczb od n do 0)
    // Przykład: dla n=3, wynik to 3+2+1+0 = 6
    public static int calculateReturnPath(int distance) {
        if (distance <= 0) {
            return 0;
        }
        return distance + calculateReturnPath(distance - 1);
    }

    // 4. SRP - Metoda procesowa (sklejająca)
    public static void performDailyRoutine() {
        int energy = 20;
        int distance = 120;

        System.out.println("---RAPORT ROBOTA---");
        System.out.println("Startowa energia: " + energy + "%");

        // Ładowanie o jednostki
        energy = charge(energy, 30);
        System.out.println("Energia po doładowaniu: " + energy + "%");

        // Ładowanie do pełna
        energy = charge(energy, true);
        System.out.println("Energia po ładowaniu do pełna: " + energy + "%");

        // Obliczanie drogi powrotnej
        int energyNeeded = calculateReturnPath(distance);
        System.out.println("Dystans do bazy: " + distance);
        System.out.println("Energia potrzebna na powrót: " + energyNeeded + "%");

        if (energy >= energyNeeded) {
            System.out.println("Status: Robot bezpiecznie wróci do bazy.");
        } else {
            System.out.println("Status: OSTRZEŻENIE! Zbyt mało energii.");
        }
    }

    public static void main(String[] args) {
        performDailyRoutine();
    }
}