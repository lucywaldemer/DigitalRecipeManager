package org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models;

public enum CuisineType {
    CHINESE("Chinese"),
    INDIAN("Indian"),
    MEXICAN("Mexican"),

    MEDITERRANEAN("Mediterranean"),
    AMERICAN("American"),
    TURKISH("Turkish"),
    GREEK("GREEK"),
    FRENCH("French"),
    ITALIAN("Italian"),
    JAPANESE("Japanese"),
    KOREAN("Korean"),
    NONE("None");

    private final String displayCuisineName;

    CuisineType(String displayCuisineName) {
        this.displayCuisineName = displayCuisineName;
    }

    public String getDisplayCuisineName() {
        return displayCuisineName;
    }
}
