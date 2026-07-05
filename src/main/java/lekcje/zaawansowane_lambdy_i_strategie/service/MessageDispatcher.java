package main.java.lekcje.zaawansowane_lambdy_i_strategie.service;

import main.java.lekcje.zaawansowane_lambdy_i_strategie.EncryptionStrategy;
import main.java.lekcje.zaawansowane_lambdy_i_strategie.model.Message;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class MessageDispatcher {
    public void dispatch(
            List<Message> messages,
            EncryptionStrategy strategy,
            Predicate<Message> filter,
            Consumer<String> sender
    ) {
        for (Message msg : messages) {
            if (filter.test(msg)) {
                String encryptedContent = strategy.encrypt(msg.content());
                sender.accept(String.format("[WYSYŁANIE - %s] (Security: %d): %s",
                        msg.id(), msg.securityLevel(), encryptedContent));
            }
        }
    }

}
