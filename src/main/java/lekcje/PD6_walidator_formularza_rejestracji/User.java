package main.java.lekcje.PD6_walidator_formularza_rejestracji;

public record User(String name, String email, String hashedPassword) {
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", hashedPassword='" + hashedPassword + '\'' +
                '}';
    }
}
