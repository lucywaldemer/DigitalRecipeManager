package org.liftoff.DigitalRecipeManager.DigitalRecipeManager.Models;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Integer> {
        List<Recipe> findByCategory(String category);
        List<Recipe> findAll();
    }
