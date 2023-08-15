package org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models;

public enum DietType {
    VEGAN("Vegan"),
    VEGETARIAN("Vegetarian"),
    CARNIVORE("Carnivore"),
    KETOGENIC("Ketogenic"),
    DIABETIC("Diabetic"),
    GLUTENFREE("GlutenFree"),
    LOWCARB("LowCarb"),
    LOWSODIUM("LowSodium"),
    LOWFAT("LowFat"),
    PLANTBASED("PlantBased"),
    NONE("None");
  
    private final String displayDietName;

    DietType(String displayDietName) {
        this.displayDietName = displayDietName;
    }

    public String getDisplayDietName() {
        return displayDietName;
    }
}

