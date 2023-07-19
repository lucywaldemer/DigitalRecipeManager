package org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models.dto;

public class SearchFormDTO {
    private String ingredient;
    private String diet;
    private String title;
    private int cookingTime;
    private String cuisineType;

    public String getIngredient() {
        return ingredient;
    }

    public String getDiet() {
        return diet;
    }

    public String getTitle() {
        return title;
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
        this.diet = diet;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCookingTime(int cookingTime) {
        this.cookingTime = cookingTime;
    }

    public void setCuisineType(String cuisineType) {
        this.cuisineType = cuisineType;
    }
}
