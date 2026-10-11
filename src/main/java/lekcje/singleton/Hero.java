package main.java.lekcje.singleton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hero {
    private final String name;
    private final String profession;
    private final int level;
    private final boolean isPremium;
    private final List<String> inventory;

    private Hero(Builder builder) {
        this.name = builder.name;
        this.profession = builder.profession;
        this.level = builder.level;
        this.isPremium = builder.isPremium;

        if (builder.inventory == null) {
            this.inventory = Collections.emptyList();
        } else {
            this.inventory = Collections.unmodifiableList(new ArrayList<>(builder.inventory));
        }
    }

    public String getName() { return name; }
    public String getProfession() { return profession; }
    public int getLevel() { return level; }
    public boolean isPremium() { return isPremium; }
    public List<String> getInventory() { return inventory; }

    // 2. Wewnętrzna, statyczna klasa Builder
    public static class Builder {
        private String name;
        private String profession;
        private int level;
        private boolean isPremium;
        private List<String> inventory;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder profession(String profession) {
            this.profession = profession;
            return this;
        }

        public Builder level(int level) {
            this.level = level;
            return this;
        }

        public Builder isPremium(boolean isPremium) {
            this.isPremium = isPremium;
            return this;
        }

        public Builder addContentToInventory(String item) {
            if (this.inventory == null) {
                this.inventory = new ArrayList<>(); // Leniwa inicjalizacja
            }
            this.inventory.add(item);
            return this;
        }
        public Hero build() {
            if (this.name == null || this.profession == null) {
                throw new IllegalArgumentException("Pola 'name' oraz 'profession' nie mogą być null!");
            }
            return new Hero(this);
        }
    }
}