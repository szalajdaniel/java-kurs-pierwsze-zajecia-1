package main.java.lekcje.multithreaded;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class MainBank {
    public static void main(String[] args) {
        Bank bank = new Bank();
        long initialTotalBalance = 0;

        for (long i = 1; i <= 10; i++) {
            long startAmount = 1000_00L;
            bank.addAccount(new BankAccount(i, startAmount));
            initialTotalBalance += startAmount;
        }

        System.out.printf("Suma sald przed symulacją: %.2f PLN\n", initialTotalBalance / 100.0);

        Random random = new Random();
        List<CompletableFuture<Void>> futures = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            long fromId = random.nextInt(10) + 1;
            long toId = random.nextInt(10) + 1;

            while (fromId == toId) {
                toId = random.nextInt(10) + 1;
            }

            long amount = (random.nextInt(401) + 100) * 100L;

            futures.add(bank.transfer(fromId, toId, amount));
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        long finalTotalBalance = bank.getAccounts().values().stream()
                .mapToLong(BankAccount::getBalance)
                .sum();

        System.out.printf("Suma sald po symulacji: %.2f PLN\n", finalTotalBalance / 100.0);

        if (initialTotalBalance == finalTotalBalance) {
            System.out.println("SUKCES: Suma sald się zgadza. Brak wyścigu wątków (race condition)!");
        } else {
            System.out.println("BŁĄD KRYTYCZNY: Pieniądze zniknęły lub wzięły się znikąd!");
        }

        bank.shutdown();
    }
}