package org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Ingredient extends AbstractEntity {
    @NotNull
    private String name;

    @ManyToMany(mappedBy = "ingredients")
    private final List<Recipe> recipes = new ArrayList<>();
    public Ingredient() {}
    public Ingredient(String name) {

        this.name = name;
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
