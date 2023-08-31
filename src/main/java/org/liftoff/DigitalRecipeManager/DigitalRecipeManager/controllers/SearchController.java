package org.liftoff.DigitalRecipeManager.DigitalRecipeManager.controllers;

import org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models.KeywordSearch;
import org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models.Recipe;
import org.liftoff.DigitalRecipeManager.DigitalRecipeManager.data.RecipeRepository;
import org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models.RecipeService;
import org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models.dto.SearchFormDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;


@Controller
@RequestMapping("search")
public class SearchController {

    @Autowired
    public RecipeRepository recipeRepository;


    @GetMapping ("/search")
    public String displaySearchForm(Model model) {
        model.addAttribute("searchForm", new SearchFormDTO());
        return "search/search";
    }

    @PostMapping("/search_results")
    public String processSearchByTerm(@RequestParam String searchTerm, Model model) {
        List<Recipe> allRecipes = (List<Recipe>) recipeRepository.findAll(); // Retrieve all recipes

        KeywordSearch keywordSearch = new KeywordSearch();
        List<Recipe> searchResults = keywordSearch.searchByKeyword(allRecipes, searchTerm);

        model.addAttribute("searchResults", searchResults);
        model.addAttribute("searchTerm", searchTerm);
        return "search/search_results"; // template for displaying search results
    }


//    @RequestMapping("/search")
//    public String displaySearchForm(Model model) {
//        model.addAttribute("searchForm", new SearchFormDTO());
//        return "search";
//    }
//
//    @PostMapping("/search")
//    public String processSearchForm(@RequestParam String searchTerm, @RequestParam String searchType, @ModelAttribute SearchFormDTO searchForm, Model model) {
//
//        String ingredient = searchForm.getIngredient();
//        String dietType = searchForm.getDietType();
//        String name = searchForm.getName();
//        int cookingTime = searchForm.getCookingTime();
//        String cuisineType = searchForm.getCuisineType();
//        String mealType = searchForm.getMealType();
//        String measurement = searchForm.getMeasurement();
//
//        List<Recipe> searchResults = recipeRepository.findByIngredientsAndDietTypeAndNameAndCuisineTypeAndMealTypeAndCookingTimeAndMeasurement//findByAll
//                (ingredient, dietType, name, cuisineType, mealType,
//                        cookingTime, measurement);
//
//        model.addAttribute("searchResults", searchResults);
//        return "search";
//    }

}