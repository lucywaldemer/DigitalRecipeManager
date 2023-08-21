package org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models;

import java.util.ArrayList;
import java.util.List;

public class KeywordSearch {

    public List<Recipe> searchByKeyword(List<Recipe> recipes, String keyword) {
        List<Recipe> results = new ArrayList<>();
        keyword = keyword.toLowerCase(); // case insensitive

        for (Recipe recipe : recipes) {
            if (containsKeyword(recipe, keyword)) {
                results.add(recipe);
            }
        }

        return results;
    }

    private boolean containsKeyword(Recipe recipe, String keyword) {
        String name = recipe.getName().toLowerCase();
//        String description = recipe.getDescription().toLowerCase();
        String mealType = recipe.getMealType().toString().toLowerCase();
        String dietType = recipe.getDietType().toString().toLowerCase();
        String cuisineType = recipe.getCuisineType().toString().toLowerCase();
        String ingredients = getIngredientsAsString(recipe.getIngredients()).toLowerCase();

        return name.contains(keyword) ||
//                description.contains(keyword) ||
                mealType.contains(keyword) ||
                dietType.contains(keyword) ||
                cuisineType.contains(keyword) ||
                ingredients.contains(keyword);
    }

    private String getIngredientsAsString(List<Ingredient> ingredients) {
        StringBuilder builder = new StringBuilder();
        for (Ingredient ingredient : ingredients) {
            builder.append(ingredient.getName()).append(",");
        }
        return builder.toString();
    }
}
