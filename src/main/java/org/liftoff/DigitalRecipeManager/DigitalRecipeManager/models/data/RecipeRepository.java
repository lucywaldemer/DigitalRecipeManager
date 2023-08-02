package org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models.data;
import org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models.Ingredient;
import org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Integer> {

    Recipe findById(int recipeId);

}




