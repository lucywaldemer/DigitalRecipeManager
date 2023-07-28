package org.liftoff.DigitalRecipeManager.DigitalRecipeManager.data;

import org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models.Recipe;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class RecipeData {
    private static final Map<Integer, Recipe> recipes = new HashMap<>();

    public static void add(Recipe recipe)   {
        recipes.put(recipe.getId(), recipe);


    }
    public static Recipe getById(int id)    {
        return recipes.get(id);
    }
    public static Collection<Recipe> getAll()    {
        return recipes.values();

    }

    public static void remove(int id)  {
        recipes.remove(id);
    }


}

