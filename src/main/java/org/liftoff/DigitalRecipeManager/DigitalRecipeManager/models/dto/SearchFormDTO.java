package org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models.dto;

public class SearchFormDTO {
    private String ingredient;
<<<<<<< HEAD
    public String dietType;
    public String name;
    public int cookingTime;
    public String cuisineType;
    public String mealType;
=======
    private String dietType;
    private String name;
    private int cookingTime;
    private String cuisineType;
    private String mealType;
    private String measurement;
>>>>>>> 38845061e8994e742dc4f1c75ec6e0478b4eb397
    public String getIngredient() {
        return ingredient;
    }

    public String getDietType() {
        return dietType;
    }

    public String getName() {
        return name;
    }


    public int getCookingTime() {
        return cookingTime;
    }


    public String getCuisineType() {
        return cuisineType;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public String getMealType() {
        return mealType;
    }


    public String getMeasurement() {
        return measurement;
    }

    public void setMeasurement(String measurement) {
        this.measurement = measurement;
    }
}