package org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;

@Entity
public class Ingredient extends AbstractEntity{

    @NotNull
    private String name;

    @ManyToMany
    private final List<Recipe> recipes = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    @Override
    public String toString() {
        return name;
    }
}
