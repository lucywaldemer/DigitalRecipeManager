package org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

//This class creates a composite primary key for the Recipe/Ingredients join table
@Embeddable
public class RecipeMeasurementId implements Serializable {
    @Column (name="recipe_id")
    private Integer RecipeId;
    @Column(name ="ingredient_id")
    private Integer IngredientId;

    public RecipeMeasurementId () {}

    public RecipeMeasurementId (Integer recipeId, Integer ingredientId) {
        this.RecipeId = recipeId;
        this.IngredientId = ingredientId;
    }

    public Integer getRecipeId() {
        return RecipeId;
    }

    public void setRecipeId(Integer recipeId) {
        RecipeId = recipeId;
    }

    public Integer getIngredientId() {
        return IngredientId;
    }

    public void setIngredientId(Integer ingredientId) {
        IngredientId = ingredientId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeMeasurementId that = (RecipeMeasurementId) o;
        return getRecipeId().equals(that.getRecipeId()) && getIngredientId().equals(that.getIngredientId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRecipeId(), getIngredientId());
    }
}
