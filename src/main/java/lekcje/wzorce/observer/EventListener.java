package main.java.lekcje.wzorce.observer;
@FunctionalInterface
public interface EventListener {
    void onEvent(Event event);
}
