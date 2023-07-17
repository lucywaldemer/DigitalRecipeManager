package org.liftoff.DigitalRecipeManager.DigitalRecipeManager.Controllers;

import org.liftoff.DigitalRecipeManager.DigitalRecipeManager.Models.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Controller
public class HomeController {

    @Autowired
    private RecipeRepository recipeRepository;

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("title", "My Recipes");
        model.addAttribute("recipes", recipeRepository.findAll());
        return "index";
    }

    @GetMapping("/recipes/add")
    public String displayAddRecipeForm(Model model) {
        model.addAttribute("title", "Add Recipe");
        model.addAttribute(new Recipe());
        return "add-recipe";
    }

    @PostMapping("/recipes/add")
    public String processAddRecipeForm(@ModelAttribute @Valid Recipe newRecipe,
                                       Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Recipe");
            return "add-recipe";
        }
        recipeRepository.save(newRecipe);
        return "redirect:/";
    }

    @GetMapping("/recipes/view/{recipeId}")
    public String displayViewRecipe(Model model, @PathVariable int recipeId) {
        Optional<Recipe> optRecipe = recipeRepository.findById(recipeId);
        if (optRecipe.isPresent()) {
            Recipe recipe = optRecipe.get();
            model.addAttribute("recipe", recipe);
            return "view-recipe";
        } else {
            return "redirect:/";
        }
    }

}
