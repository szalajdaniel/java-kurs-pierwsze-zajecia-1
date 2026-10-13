package main.java.lekcje.wzorce.observer;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class EventBus {
    Map<String, List<EventListener>> listeners = new ConcurrentHashMap<>();
    public void subscribe(String eventType, EventListener listener){
        Objects.requireNonNull(eventType, "Typ eventu nie może być pusty");
        Objects.requireNonNull(listener, "Nasłuchiwacz nie może być pusty");
        listeners.computeIfAbsent(eventType, k -> new CopyOnWriteArrayList<>()).add(listener);
    }

    public void publish(Event event){
        Objects.requireNonNull(event, "Brak eventu");
        List<EventListener> interested = listeners.getOrDefault(event.type(), List.of());
        for (EventListener listener : interested){
            try {
                listener.onEvent(event);
            } catch (Exception e){
                System.err.println("Listener rzucił jakiś wyjatek");
            }
        }

    }
}
