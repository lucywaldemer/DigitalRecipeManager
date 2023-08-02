package org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Ingredient extends AbstractEntity {
    private String name;
    private final List<Recipe> recipes = new ArrayList<>();

    public Ingredient(String name) {
        this.name = name;
    }
  
    public Ingredient() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }
    public void addRecipe(Recipe recipe) {this.recipes.add(recipe);}

    @Override
    public String toString() {
        return name;
    }

}
