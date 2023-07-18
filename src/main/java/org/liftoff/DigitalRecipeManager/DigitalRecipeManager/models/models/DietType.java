package org.liftoff.DigitalRecipeManager.DigitalRecipeManager.Models.models;

public enum DietType {
    VEGAN("Vegan"),
    VEGETARIAN("Vegetarian"),
    KETOGENIC("Ketogenic"),
    GLUTENFREE("GlutenFree"),
    LOWCARB("LowCarb"),
    LOWSODIUM("LowSodium");

    private final String displayDietName;

    DietType(String displayDietName) {
        this.displayDietName = displayDietName;
    }

    public String getDisplayDietName() {
        return displayDietName;
    }
}

