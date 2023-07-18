package org.liftoff.DigitalRecipeManager.DigitalRecipeManager.Models.models;

public enum CuisineType {
    CHINESE("Chinese"),
    INDIAN("Indian"),
    MEXICAN("Mexican"),
    MEDITERRANEAN("Mediterranean");

    private final String displayCuisineName;

    CuisineType(String displayCuisineName) {
        this.displayCuisineName = displayCuisineName;
    }

    public String getDisplayCuisineName() {
        return displayCuisineName;
    }
}
