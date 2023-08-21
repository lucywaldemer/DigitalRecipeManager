package org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models.dto;

public class SearchFormDTO {
    public String ingredient;
    public String dietType;
    public String name;
    public int cookingTime;
    public String cuisineType;
    public String mealType;
//    public String measurement;

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


//    public String getMeasurement() {
//        return measurement;
//    }
//
//    public void setMeasurement(String measurement) {
//        this.measurement = measurement;
//    }



}