package org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Ingredient extends AbstractEntity {
    @NotNull
    private String name;

    @OneToMany(mappedBy = "ingredient")
    private final List<RecipeMeasurement> recipes = new ArrayList<>();
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

    public List<RecipeMeasurement> getRecipes() {
        return recipes;
    }


    public void addRecipe(RecipeMeasurement recipe) {this.recipes.add(recipe);}


    @Override
    public String toString() {
        return name;
    }
}
