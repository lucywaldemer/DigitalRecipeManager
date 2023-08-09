package org.liftoff.DigitalRecipeManager.DigitalRecipeManager.controllers;

import org.liftoff.DigitalRecipeManager.DigitalRecipeManager.data.IngredientRepository;
import org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models.Ingredient;
import org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("ingredients")
public class IngredientController {

    @Autowired
    IngredientRepository ingredientRepository;
    @Autowired
    private RecipeService recipeService;
    @GetMapping("/all")
    public Ingredient[] getAllIngredients() {
        return recipeService.findAllIngredients();
    }
    @GetMapping("add")
    public String displayAddIngredientForm(Model model) {
        model.addAttribute("title", "Add Ingredient");
        model.addAttribute(new Ingredient());

        return "ingredients/add";
    }

    @PostMapping("add")
    public String processAddIngredientForm(@ModelAttribute @Valid Ingredient newIngredient,
                                      Errors errors, Model model) {

        if (errors.hasErrors()) {
            return "ingredients/add";
        } else {
            ingredientRepository.save(newIngredient);
        }

        return "redirect:";
    }

}
