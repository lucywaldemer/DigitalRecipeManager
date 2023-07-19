package org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models.data;

import org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Integer> {
}
