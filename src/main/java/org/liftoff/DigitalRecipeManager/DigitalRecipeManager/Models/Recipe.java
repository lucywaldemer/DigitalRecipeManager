package org.liftoff.DigitalRecipeManager.DigitalRecipeManager.Models;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Recipe extends AbstractEntity {

    private String title;
    private String description;
    private String instructions;
    private String imageUrl;

    public Recipe() {
    }

    @Column(nullable = false)
    private String category;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}

