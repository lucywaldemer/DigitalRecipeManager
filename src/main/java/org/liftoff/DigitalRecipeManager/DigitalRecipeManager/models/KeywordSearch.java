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
        String lowerCaseKeyword = keyword.toLowerCase();

        return recipe.getName().toLowerCase().contains(lowerCaseKeyword) ||
                recipe.getDietType().toLowerCase().contains(lowerCaseKeyword) ||
                recipe.getDescription().toLowerCase().contains(lowerCaseKeyword) ||
                recipe.getMealType().toLowerCase().contains(lowerCaseKeyword) ||
                recipe.getCuisineType().toLowerCase().contains(lowerCaseKeyword);
//                containsKeywordInIngredients(recipe, lowerCaseKeyword);
    }

//    private boolean containsKeywordInIngredients(Recipe recipe, String keyword) {
//        for (Ingredient ingredients : recipe.getIngredients()) {
//            if (ingredients.split()(keyword)) {
//                return true;
//            }
//        }
//        return false;
//    }
}
