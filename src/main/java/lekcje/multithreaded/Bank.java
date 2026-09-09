package main.java.lekcje.multithreaded;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.*;

class Bank {
    private final ConcurrentHashMap<Long, BankAccount> accounts = new ConcurrentHashMap<>();
    private final ExecutorService executor = Executors.newFixedThreadPool(5);

    // ZADANIE BONUSOWE: Kolejka dla Audytora
    private final BlockingQueue<String> transactionLog = new LinkedBlockingQueue<>();
    private final Thread auditorThread;

    public Bank() {
        auditorThread = new Thread(() -> {
            try (PrintWriter writer = new PrintWriter(new FileWriter("transactions.txt", true))) {
                while (true) {
                    // take() blokuje wątek dopóki nic nie ma w kolejce – brak aktywnego czekania!
                    String log = transactionLog.take();
                    writer.println(log);
                    writer.flush(); // Zabezpieczenie przed utratą danych z bufora
                }
            } catch (IOException e) {
                System.err.println("Błąd zapisu do pliku: " + e.getMessage());
            } catch (InterruptedException e) {
                // Wątek został przerwany (np. przy wyłączaniu systemu), kończymy pracę
                Thread.currentThread().interrupt();
            }
        }, "Auditor-Thread");

        // Ustawiamy jako daemon, by nie blokował zamknięcia JVM (ew. obsługujemy shutdown ręcznie)
        auditorThread.setDaemon(true);
        auditorThread.start();
    }

    public void addAccount(BankAccount account) {
        accounts.put(account.getId(), account);
    }

    public ConcurrentHashMap<Long, BankAccount> getAccounts() {
        return accounts;
    }

    public CompletableFuture<Void> transfer(Long fromId, Long toId, long amount) {
        return CompletableFuture.runAsync(() -> {
            BankAccount from = accounts.get(fromId);
            BankAccount to = accounts.get(toId);

            if (from == null || to == null || from.getId().equals(to.getId())) {
                return;
            }

            BankAccount firstLock = from.getId() < to.getId() ? from : to;
            BankAccount secondLock = from.getId() < to.getId() ? to : from;

            synchronized (firstLock) {
                synchronized (secondLock) {
                    if (from.withdraw(amount)) {
                        to.deposit(amount);

                        String logMsg = String.format("Przelew z %d na %d, kwota: %.2f PLN",
                                fromId, toId, amount / 100.0);
                        transactionLog.offer(logMsg);
                    }
                }
            }
        }, executor);
    }

    public void shutdown() {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}