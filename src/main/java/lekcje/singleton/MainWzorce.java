package main.java.lekcje.singleton;

public class MainWzorce {
    public static void main(String[] args) {
        Hero mojBohater = new Hero.Builder()
                .name("Artur")
                .profession("Mag")
                .level(10)
                .isPremium(true)
                .addContentToInventory("Różdżka")
                .addContentToInventory("Mikstura many")
                .build();

    }

}
