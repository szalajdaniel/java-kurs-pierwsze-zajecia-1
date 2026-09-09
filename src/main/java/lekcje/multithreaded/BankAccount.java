package main.java.lekcje.multithreaded;

import java.util.concurrent.atomic.AtomicLong;

class BankAccount {
    private final Long id;
    private final AtomicLong balance;

    public BankAccount(Long id, long initialBalance) {
        this.id = id;
        this.balance = new AtomicLong(initialBalance);
    }

    public Long getId() {
        return id;
    }

    public long getBalance() {
        return balance.get();
    }

    public void deposit(long amount) {
        balance.updateAndGet(current -> current + amount);
    }

    public boolean withdraw(long amount) {
        long previousBalance = balance.getAndUpdate(current ->
                current >= amount ? current - amount : current
        );
        return previousBalance >= amount;
    }
}