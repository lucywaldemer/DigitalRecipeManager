package org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class RandomRecipeResponse {
    @JsonProperty("meals")
    private List<RandomRecipe> meals;

    public List<RandomRecipe> getMeals() {
        return meals;
    }

    public void setMeals(List<RandomRecipe> meals) {
        this.meals = meals;
    }
}
