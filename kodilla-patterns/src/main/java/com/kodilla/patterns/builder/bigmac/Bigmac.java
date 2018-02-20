package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.List;

public class Bigmac {
    private final RollType roll;
    private final int burgers;
    private final SauceType sauce;
    private final List<IngredientType> ingredients;

    public static enum RollType {
        ROLL_WITH_SESAME,
        STANDARD_ROLL
    }

    public static enum SauceType {
        STANDARD,
        THOUSAND_ISLANDS,
        BARBECUE
    }

    public static enum IngredientType {
        LETTUCE,
        ONION,
        BACON,
        CUCUMBER,
        CHILI_PEPPER,
        MUSHROOM,
        SHRIMP,
        CHEESE
    }

    public static class BigmacBuilder {
        private RollType roll;
        private int burgers;
        private SauceType sauce;
        private List<IngredientType> ingredients = new ArrayList<>();

        public BigmacBuilder roll(final RollType roll) {
            this.roll = roll;
            return this;
        }

        public BigmacBuilder burgers(final int burgers) {
            this.burgers = burgers;
            return this;
        }

        public BigmacBuilder sauce(final SauceType sauce) {
            this.sauce = sauce;
            return this;
        }

        public BigmacBuilder ingredient(final IngredientType ingredient) {
            this.ingredients.add(ingredient);
            return this;
        }

        public Bigmac build() {
            return new Bigmac(roll, burgers, sauce, ingredients);
        }
    }

    /**
     * Task 11.5. Constructing BigMac.
     *
     * @param roll        roll type
     * @param burgers     amount of burgers
     * @param sauce       sauce type
     * @param ingredients additional ingredients
     */
    private Bigmac(final RollType roll, final int burgers, final SauceType sauce, final List<IngredientType> ingredients) {
        this.roll = roll;
        this.burgers = burgers;
        this.sauce = sauce;
        this.ingredients = ingredients;
    }

    public RollType getRoll() {
        return roll;
    }

    public int getBurgers() {
        return burgers;
    }

    public SauceType getSauce() {
        return sauce;
    }

    public List<IngredientType> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return "Bigmac{" +
                "roll=" + roll +
                ", burgers=" + burgers +
                ", sauce=" + sauce +
                ", ingredients=" + ingredients +
                '}';
    }
}
