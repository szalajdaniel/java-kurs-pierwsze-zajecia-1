package main.java.lekcje.zaawansowane_lambdy_i_strategie.service;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import main.java.lekcje.zaawansowane_lambdy_i_strategie.model.Event;

public class EventProcessor {
    public void process(
            List<Event> events,
            List<Predicate<Event>> filters,
            Function<Event, String> formatter,
            Consumer<String> output
    ) {

        Predicate<Event> combinedPredicate = e -> true;
        for (Predicate<Event> filter : filters) {
            combinedPredicate = combinedPredicate.and(filter);
        }

        for (Event event : events) {
            if (combinedPredicate.test(event)) {
                String formatted = formatter.apply(event);
                output.accept(formatted);
            }
        }
    }
}
