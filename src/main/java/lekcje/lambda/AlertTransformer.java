package main.java.lekcje.lambda;

@FunctionalInterface
public interface AlertTransformer {
    String transform(String message, String prefix);
}
