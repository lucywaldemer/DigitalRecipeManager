package org.liftoff.DigitalRecipeManager.DigitalRecipeManager.data;

import org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Integer> {

    Recipe findById(int recipeId);

    List<Recipe> findByIngredientsAndDietTypeAndNameAndCuisineTypeAndMealTypeAndCookingTime
            (String ingredient, String dietType, String name, String cuisineType, String mealType, int cookingTime);

    //List<Recipe> findByAll(String ingredient, String dietType, String name, String cuisineType, String mealType,
    //                int cookingTime);
}
