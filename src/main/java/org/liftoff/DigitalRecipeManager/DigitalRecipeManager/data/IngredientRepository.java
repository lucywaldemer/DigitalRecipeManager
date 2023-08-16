package org.liftoff.DigitalRecipeManager.DigitalRecipeManager.data;

import org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models.Ingredient;
import org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Integer> {

    Ingredient findById(int ingredientId);
}

