package org.liftoff.DigitalRecipeManager.DigitalRecipeManager.Controllers;

import org.liftoff.DigitalRecipeManager.DigitalRecipeManager.Models.Recipe;
import org.liftoff.DigitalRecipeManager.DigitalRecipeManager.Models.RecipeData;
import org.liftoff.DigitalRecipeManager.DigitalRecipeManager.Models.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("search")
public class SearchController {

    @Autowired
    private RecipeRepository recipeRepository;

    @GetMapping("")
    public String search(Model model) {
        model.addAttribute("categories", RecipeData.getAllCategories());
        return "search";
    }

    @PostMapping("results")
    public String displaySearchResults(Model model, @RequestParam String category) {
        List<Recipe> recipes;
        if (category.equalsIgnoreCase("all")) {
            recipes = (List<Recipe>) recipeRepository.findAll();
        } else {
            recipes = recipeRepository.findByCategory(category);
        }
        model.addAttribute("categories", RecipeData.getAllCategories());
        model.addAttribute("title", "Recipes in Category: " + category);
        model.addAttribute("recipes", recipes);

        return "search";
    }
}
