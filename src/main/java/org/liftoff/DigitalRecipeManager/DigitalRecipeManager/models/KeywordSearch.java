package org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models;

import java.util.ArrayList;
import java.util.List;

public class KeywordSearch {

//    public Recipe convertAPIRecipeToRecipe(APIRecipe apiRecipe) {
//        Recipe recipe = new Recipe();
//
//        recipe.setName(apiRecipe.getStrMeal());
//        recipe.setDescription(apiRecipe.getDescription());
//        recipe.setMealType(apiRecipe.getStrCategory());
//        recipe.setIngredients(apiRecipe.getStrIngredients());
//
//        // Assuming you have a method to parse the comma-separated ingredients string
//        List<Ingredient> ingredients = parseIngredients(apiRecipe.getStrIngredients());
//        recipe.setIngredients(ingredients);
//
//        // You might need to handle conversion of other attributes such as mealType, dietType, cuisineType, cookingTime, etc.
//
//        return recipe;
//    }

//    public List<Recipe> searchByKeyword(List<Recipe> localRecipes, String keyword) {
//        List<Recipe> results = new ArrayList<>();
//        keyword = keyword.toLowerCase(); // case insensitive
//
//        for (Recipe localRecipe : localRecipes) {
//            if (containsKeyword(localRecipe, keyword)) {
//                results.add(localRecipe);
//            }
//        }
//
//        for (APIRecipe apiRecipe : apiRecipes) {
//            if (containsKeyword(apiRecipe, keyword)) {
//                results.add(apiRecipe);
//            }
//        }
//
//        return results;
//    }

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

//    private boolean containsKeyword(Object recipe, String keyword) {
//        if (recipe instanceof Recipe) {
//            Recipe localRecipe = (Recipe) recipe;
//            String name = localRecipe.getName().toLowerCase();
//            String mealType = localRecipe.getMealType().toString().toLowerCase();
//            String dietType = localRecipe.getDietType().toString().toLowerCase();
//            String cuisineType = localRecipe.getCuisineType().toString().toLowerCase();
//            String ingredients = getIngredientsAsString(localRecipe.getIngredients()).toLowerCase();
//
//            return name.contains(keyword) ||
//                    mealType.contains(keyword) ||
//                    dietType.contains(keyword) ||
//                    cuisineType.contains(keyword) ||
//                    ingredients.contains(keyword);
//        } else if (recipe instanceof APIRecipe) {
//            // Handle API recipe attributes here
//            APIRecipe apiRecipe = (APIRecipe) recipe;
//            String strMeal = apiRecipe.getStrMeal().toLowerCase();
//            String strCategory = apiRecipe.getStrCategory().toLowerCase();
//            String strIngredients = apiRecipe.getStrIngredients().toLowerCase();
//
//            return strMeal.contains(keyword);
//        }
//
//        return false;
//    }

    private String getIngredientsAsString(List<Ingredient> ingredients) {
        StringBuilder builder = new StringBuilder();
        for (Ingredient ingredient : ingredients) {
            builder.append(ingredient.getName()).append(",");
        }
        return builder.toString();
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
}

//    private boolean containsKeyword(Object recipe, String keyword) {
//        if (recipe instanceof Recipe) {
//            Recipe localRecipe = (Recipe) recipe;
//            String name = localRecipe.getName().toLowerCase();
//            String mealType = localRecipe.getMealType().toString().toLowerCase();
//            String dietType = localRecipe.getDietType().toString().toLowerCase();
//            String cuisineType = localRecipe.getCuisineType().toString().toLowerCase();
//            String ingredients = getIngredientsAsString(localRecipe.getIngredients()).toLowerCase();
//
//            return name.contains(keyword) ||
//                    mealType.contains(keyword) ||
//                    dietType.contains(keyword) ||
//                    cuisineType.contains(keyword) ||
//                    ingredients.contains(keyword);
//        } else if (recipe instanceof APIRecipe) {
//            // Handle API recipe attributes here
//            APIRecipe apiRecipe = (APIRecipe) recipe;
//            String strMeal = apiRecipe.getStrMeal().toLowerCase();
//            String strCategory = apiRecipe.getStrCategory().toLowerCase();
//            String strIngredients = apiRecipe.getStrIngredients().toLowerCase();
//
//            return strMeal.contains(keyword);
//        }
//
//        return false;
//    }
