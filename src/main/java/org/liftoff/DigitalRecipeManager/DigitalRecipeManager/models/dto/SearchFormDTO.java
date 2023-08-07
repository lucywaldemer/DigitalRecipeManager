package org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models.dto;

public class SearchFormDTO {
    private String ingredient;
    private String dietType;
    private String name;
    private int cookingTime;
    private String cuisineType;
    private String mealType;
    public String getIngredient() {
        return ingredient;
    }

    public String getDiet() {
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

    public void setDiet(String diet) {
        this.dietType = diet;
    }

    public void setTitle(String name) {
        this.name = name;
    }

    public void setCookingTime(int cookingTime) {
        this.cookingTime = cookingTime;
    }

    public void setCuisineType(String cuisineType) {
        this.cuisineType = cuisineType;
    }

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }
}
