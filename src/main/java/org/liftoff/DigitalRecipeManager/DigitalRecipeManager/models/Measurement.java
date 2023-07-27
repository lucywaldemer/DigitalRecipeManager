package org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models;

public enum Measurement {
    TEASPOON("Teaspoon"),
    TABLESPOON("Tablespoon"),
    CUP("Cup"),
    OUNCE("Ounce"),
    KILOGRAM("Kilogram"),
    GRAM("Gram");


    private final String displayMeasurementName;

    Measurement(String displayMeasurementName) {

        this.displayMeasurementName = displayMeasurementName;
    }

    public String getDisplayMeasurementName() {

        return displayMeasurementName;
    }
}
