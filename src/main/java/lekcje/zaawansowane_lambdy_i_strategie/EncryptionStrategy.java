package main.java.lekcje.zaawansowane_lambdy_i_strategie;
@FunctionalInterface
public interface EncryptionStrategy {
    String encrypt(String text);
}
