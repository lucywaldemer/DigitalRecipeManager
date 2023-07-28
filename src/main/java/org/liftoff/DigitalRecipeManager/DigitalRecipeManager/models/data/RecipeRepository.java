package org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Integer> {

    List<Recipe> findByIngredientsContaining(String ingredient);
    List<Recipe> findBySpecialDietsContaining(String diet);
    List<Recipe> findByTitleContaining(String title);
    List<Recipe> findByCuisineType(String cuisineType);
    List<Recipe> findByCookingTimeLessThan(int cookingTime);
    List<Recipe> findByAll(String ingredient, String diet, String title, String cuisineType, int cookingTime);
}
