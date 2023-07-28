package org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models;

Senay
import java.util.ArrayList;
import java.util.List;

public class Ingredient {
    private int id;
    private static int nextId = 1;
    private String name;
    private final List<Recipe> recipes = new ArrayList<>();

    public Ingredient(String name) {
        this();
        this.name = name;
    }
  
    public Ingredient() {
        this.id = nextId;
        nextId++;
    }

    public int getId() {
        return id;
    }

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
