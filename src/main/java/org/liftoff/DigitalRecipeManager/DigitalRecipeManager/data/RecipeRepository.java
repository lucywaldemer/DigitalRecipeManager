package org.liftoff.DigitalRecipeManager.DigitalRecipeManager.data;

import org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Integer> {

    Recipe findById(int recipeId);

    List<Recipe> findByIngredientsContaining(String ingredient);
    List<Recipe> findByDietTypeContaining(String diet);
    List<Recipe> findByNameContaining(String name);
    List<Recipe> findByCuisineType(String cuisineType);
    List<Recipe> findByCookingTimeLessThan(int cookingTime);
    List<Recipe> findByIngredientsAndDietTypeAndNameAndCuisineTypeAndCookingTimeLessThanAndMealType(String ingredient, String dietType, String name, String cuisineType, String mealType, int cookingTime);
    List<Recipe> findAll();
}
