package main.java.lekcje.generycz_procesor_zadan;

public interface Task<T> {
    void execute(T data);
}