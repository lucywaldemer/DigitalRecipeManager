package org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table
public class RecipeMeasurement {

    //declare composite key for join table
    @EmbeddedId
    private RecipeMeasurementId id;

    //Join table fields
    @ManyToOne
    @MapsId("RecipeId")
    private Recipe recipe;

    @ManyToOne
    @MapsId("IngredientId")
    private Ingredient ingredient;

    @Column
    @Enumerated(EnumType.STRING)
    private Measurement measurement;

    @Column
    private Integer quantity;

    //Constructors
    public RecipeMeasurement () {}

    public RecipeMeasurement (Recipe recipe, Ingredient ingredient,Measurement measurement, Integer quantity) {
        this.recipe = recipe;
        this.ingredient = ingredient;
        this.measurement = measurement;
        this.quantity = quantity;
    }

    //Getters and Setters
    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public Measurement getMeasurement() {
        return measurement;
    }

    public void setMeasurement(Measurement measurement) {
        this.measurement = measurement;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    //equals and hashcode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeMeasurement that = (RecipeMeasurement) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

