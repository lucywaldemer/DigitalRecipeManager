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
        return recipe.getName().toLowerCase().contains(keyword) ||
                recipe.getDietType().toLowerCase().contains(keyword) ||
                recipe.getDescription().toLowerCase().contains(keyword) ||
                recipe.getMealType().toLowerCase().contains(keyword) ||
                recipe.getCuisineType().toLowerCase().contains(keyword) ||
                recipe.getIngredients().toArray().toString().toLowerCase().contains(keyword);
    }
}
