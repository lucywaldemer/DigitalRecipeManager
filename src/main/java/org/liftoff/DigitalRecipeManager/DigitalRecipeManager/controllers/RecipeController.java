package org.liftoff.DigitalRecipeManager.DigitalRecipeManager.controllers;

import org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models.*;
import org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models.data.IngredientRepository;
import org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models.data.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;


@RestController
@Controller
@RequestMapping("recipes")
public class RecipeController {

    @Autowired
    private IngredientRepository ingredientRepository;
    @Autowired
    private RecipeRepository recipeRepository;


    @GetMapping
    public String displayAllRecipes(Model model)    {
        model.addAttribute("title","All Recipes");
        model.addAttribute("recipes", recipeRepository.findAll());
        return "recipes/index";
    }


    @GetMapping("create")
    public String displayCreateRecipeForm(Model model) {
        model.addAttribute("title", "Create Recipe");
        model.addAttribute(new Recipe());
        model.addAttribute("mealTypes", MealType.values());
        model.addAttribute("cuisineTypes", CuisineType.values());
        model.addAttribute("dietTypes", DietType.values());
        return "recipes/create";
    }

    @PostMapping("create")
    public String processCreateRecipeForm(@ModelAttribute @Valid Recipe newRecipe,
                                          Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Create Recipe");
            return "recipes/create";
        }
            recipeRepository.save(newRecipe);
            return "redirect:";
        }

    @GetMapping("delete")
    public String displayDeleteRecipeForm(Model model)   {
        model.addAttribute("title", "Delete Recipe");
        model.addAttribute("recipes", recipeRepository.findAll());
        return "recipes/delete";
    }
    @PostMapping("delete")
    public String processDeleteRecipesForm(@RequestParam(required = false) int[] recipeIds)   {
        if  (recipeIds != null) {
            for (int id : recipeIds) {
                recipeRepository.deleteById(id);
            }
        }
        return "redirect:";
    }
    @GetMapping("edit/{recipeId}")
    public String displayEditRecipeForm(Model model, @PathVariable int recipeId) {

        Recipe recipe = recipeRepository.findById(recipeId);
        String title = "Edit Recipe " + recipe.getName() + " (id=" + recipe.getId() + ")";
        model.addAttribute("title", title );
        model.addAttribute("recipe", recipe);
        return "recipes/edit";
    }

    @PostMapping("edit")

    public String processEditRecipeForm(int recipeId, String name, String description,
                                        List<Ingredient> ingredients, int cookingTime,
                                        String instructions, String createdBy) {

        Recipe recipeToEdit = recipeRepository.findById(recipeId);
        recipeToEdit.setName(name);
        recipeToEdit.setDescription(description);
        //recipeToEdit.setContactEmail(contactEmail);
        recipeToEdit.setIngredients(ingredients);
        recipeToEdit.setCookingTime(cookingTime);
        recipeToEdit.setInstructions(instructions);
        recipeToEdit.setCreatedBy(createdBy);

        return "redirect:";
    }
}

