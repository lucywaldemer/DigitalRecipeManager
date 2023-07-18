package org.liftoff.DigitalRecipeManager.DigitalRecipeManager.Controllers;

import org.liftoff.DigitalRecipeManager.DigitalRecipeManager.Models.Recipe;
import org.liftoff.DigitalRecipeManager.DigitalRecipeManager.Models.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

    @Controller
//    @RequestMapping("recipes")
    public class RecipeController {

        @Autowired
        private RecipeRepository recipeRepository;

        @GetMapping("")
        public String index(Model model) {
            model.addAttribute("title", "All Recipes");
            List<Recipe> recipes = (List<Recipe>) recipeRepository.findAll();
            model.addAttribute("recipes", recipes);
            return "recipes/index";
        }

        @GetMapping("add")
        public String displayAddRecipeForm(Model model) {
            model.addAttribute(new Recipe());
            return "recipes/add";
        }

        @PostMapping("add")
        public String processAddRecipeForm(@ModelAttribute Recipe newRecipe,
                                           Errors errors, Model model) {
            if (errors.hasErrors()) {
                model.addAttribute("title", "Add Recipe");
                return "recipes/add";
            }
            recipeRepository.save(newRecipe);
            return "redirect:";
        }

        @GetMapping("view/{recipeId}")
        public String displayViewRecipe(Model model, @PathVariable int recipeId) {
            Optional<Recipe> optRecipe = recipeRepository.findById(recipeId);
            if (optRecipe.isPresent()) {
                Recipe recipe = optRecipe.get();
                model.addAttribute("recipe", recipe);
                return "recipes/view";
            } else {
                return "redirect../";
            }
        }
    }

