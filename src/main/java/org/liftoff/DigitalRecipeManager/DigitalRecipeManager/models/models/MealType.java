package org.liftoff.DigitalRecipeManager.DigitalRecipeManager.Models.models;


public enum MealType {
    BREAKFAST("Breakfast"),
    LUNCH("Lunch"),
    DINNER("Dinner"),
    SALADS("Salads"),
    DESSERTS("Desserts"),
    SOUPS("Soups"),
    APPETIZERS("Appetizers"),
    BREAD("Bread");


    private final String displayMealName;

    MealType(String displayMealName) {
        this.displayMealName = displayMealName;
    }

    public String getDisplayMealName() {
        return displayMealName;
    }
}
