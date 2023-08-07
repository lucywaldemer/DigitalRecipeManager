package org.liftoff.DigitalRecipeManager.DigitalRecipeManager.data;

import org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models.Recipe;
//import org.springframework.data.jpa.repository.CrudRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Integer> {

    Recipe findById(int recipeId);

    List<Recipe> findByIngredientsContaining(String ingredient);
    List<Recipe> findBySpecialDietsContaining(String diet);
    List<Recipe> findByTitleContaining(String title);
    List<Recipe> findByCuisineType(String cuisineType);
    List<Recipe> findByCookingTimeLessThan(int cookingTime);
    List<Recipe> findByAll(String ingredient, String dietType, String title, String cuisineType, String mealType, int cookingTime);
}
