package org.liftoff.DigitalRecipeManager.DigitalRecipeManager.Models;

import java.util.ArrayList;

import java.util.ArrayList;
import java.util.List;

public class RecipeData {
    private static final List<Recipe> recipes = new ArrayList<>();

    static {
        // Sample recipe data
        Recipe recipe1 = new Recipe();
        recipe1.setId(1);
        recipe1.setTitle("");
        recipe1.setDescription("");
        recipe1.setInstructions("");
        recipe1.setImageUrl("");
        recipes.add(recipe1);
    }

    public static List<Recipe> getAllRecipes() {
        return recipes;
    }

    public static List<Recipe> searchRecipesByTitle(String searchTerm) {
        List<Recipe> results = new ArrayList<>();
        for (Recipe recipe : recipes) {
            if (recipe.getTitle().toLowerCase().contains(searchTerm.toLowerCase())) {
                results.add(recipe);
            }
        }
        return results;
    }

    public static Recipe getRecipeById(int id) {
        for (Recipe recipe : recipes) {
            if (recipe.getId() == id) {
                return recipe;
            }
        }
        return null;
    }
}

