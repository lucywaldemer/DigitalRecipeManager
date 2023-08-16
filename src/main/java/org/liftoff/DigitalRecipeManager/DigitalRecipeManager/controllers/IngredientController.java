package org.liftoff.DigitalRecipeManager.DigitalRecipeManager.controllers;

import org.liftoff.DigitalRecipeManager.DigitalRecipeManager.data.IngredientRepository;
import org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

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
        model.addAttribute("ingredients", ingredientRepository.findAll());

        return "ingredients/add";
    }

    @GetMapping
    public String displayIngredients(Model model) {
        model.addAttribute("title", "Ingredients");

        model.addAttribute("ingredients", ingredientRepository.findAll());

        return "ingredients/index";
    }

    @GetMapping("edit/{ingredientId}")
    public String displayEditIngredientForm(Model model, @PathVariable int ingredientId) {
        Ingredient ingredientToEdit = ingredientRepository.findById(ingredientId);
        String title = "Edit Recipe " + ingredientToEdit.getName() + " (id=" + ingredientToEdit.getId() + ")";
        model.addAttribute("title", title );
        model.addAttribute("ingredient", ingredientToEdit);

        return "ingredients/edit";
    }

    @PostMapping("edit")
    public String processEditIngredientForm(int ingredientId, String name) {

        Ingredient ingredientToEdit = ingredientRepository.findById(ingredientId);

        ingredientToEdit.setName(name);


        ingredientRepository.save(ingredientToEdit);

        return "redirect:";
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
