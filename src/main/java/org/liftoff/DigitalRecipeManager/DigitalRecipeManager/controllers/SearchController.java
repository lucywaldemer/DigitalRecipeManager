package org.liftoff.DigitalRecipeManager.DigitalRecipeManager.controllers;

import org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models.Recipe;
import org.liftoff.DigitalRecipeManager.DigitalRecipeManager.data.RecipeRepository;
import org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models.dto.SearchFormDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class SearchController {

    @Autowired
    public RecipeRepository recipeRepository;

    @GetMapping("/search")
    public String displaySearchForm(Model model) {
        model.addAttribute("searchForm", new SearchFormDTO());
        return "search";
    }

    @PostMapping("/search")
    public String processSearchForm(@ModelAttribute SearchFormDTO searchForm, Model model) {

        String ingredient = searchForm.getIngredient();
        String dietType = searchForm.getDiet();
        String name = searchForm.getName();
        int cookingTime = searchForm.getCookingTime();
        String cuisineType = searchForm.getCuisineType();
        String mealType = searchForm.getMealType();

        List<Recipe> searchResults = recipeRepository.findByAll
                (ingredient, dietType, name, cuisineType, mealType,
                cookingTime);

        model.addAttribute("searchResults", searchResults);
        return "search_results";
    }
}
