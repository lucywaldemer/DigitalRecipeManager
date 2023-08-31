package org.liftoff.DigitalRecipeManager.DigitalRecipeManager.controllers;

import org.liftoff.DigitalRecipeManager.DigitalRecipeManager.data.IngredientRepository;
import org.liftoff.DigitalRecipeManager.DigitalRecipeManager.data.RecipeMeasurementRepository;
import org.liftoff.DigitalRecipeManager.DigitalRecipeManager.data.RecipeRepository;
import org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("recipes")
public class RecipeController {

    @Autowired
    private IngredientRepository ingredientRepository;
    @Autowired
    private RecipeRepository recipeRepository;
    @Autowired
    private RecipeService recipeService;

    @Autowired
    private RecipeMeasurementRepository recipeMeasurementRepository;
    @Autowired

    AuthenticationController authenticationController;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/recipe")
    public Recipe getRecipeByName(@RequestParam String name) {
        return recipeService.searchRecipeByName(name);
    }


    @GetMapping
    public String displayAllRecipes(Model model) {
        model.addAttribute("title", "All Recipes");
        model.addAttribute("recipes", recipeRepository.findAll());
        return "recipes/index";
    }

    @GetMapping("create")
    public String displayCreateRecipeForm(Model model) {



        model.addAttribute(new Recipe());
        model.addAttribute("mealTypes", MealType.values());
        model.addAttribute("cuisineTypes", CuisineType.values());
        model.addAttribute("dietTypes", DietType.values());
        model.addAttribute("measurements", Measurement.values());
        model.addAttribute("ingredients", ingredientRepository.findAll());
        return "recipes/create";
    }

    @PostMapping("create")
    public String processCreateRecipeForm(@ModelAttribute @Valid Recipe newRecipe,
                                          Errors errors, Model model, HttpSession session,
                                          @RequestParam String ingredientsJson) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Create Recipe");
            return "recipes/create";
        }

        User user = authenticationController.getUserFromSession(session);


        if (user!=null) {

            newRecipe.setUserId(user.getId());
            newRecipe.setCreatedBy(user.getUsername());

        }

        newRecipe.setIngredientsJson((ingredientsJson));

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
        Recipe  recipeToEdit = recipeRepository.findById(recipeId);
        String title = "Edit Recipe " + recipeToEdit.getName() + " (id=" + recipeToEdit.getId() + ")";
        model.addAttribute("title", title );
        model.addAttribute("recipe", recipeToEdit);
        model.addAttribute("mealTypes", MealType.values());
        model.addAttribute("cuisineTypes", CuisineType.values());
        model.addAttribute("dietTypes", DietType.values());
        model.addAttribute("measurements", Measurement.values());
        model.addAttribute("ingredients", ingredientRepository.findAll());
        return "recipes/edit";
    }
    @PostMapping("edit")
    public String processEditRecipeForm(int recipeId, String name, String description, MealType mealType,
                                        CuisineType cuisineType, DietType dietType, int cookingTime,
                                        String instructions, String createdBy, @RequestParam String ingredientsJson) {
        Recipe recipeToEdit = recipeRepository.findById(recipeId);
        recipeToEdit.setName(name);
        recipeToEdit.setDescription(description);
        recipeToEdit.setMealType(mealType);
        recipeToEdit.setCuisineType(cuisineType);
        recipeToEdit.setDietType(dietType);
        recipeToEdit.setCookingTime(cookingTime);
        recipeToEdit.setInstructions(instructions);
        recipeToEdit.setCreatedBy(createdBy);
        recipeToEdit.setIngredientsJson(ingredientsJson);

        recipeRepository.save(recipeToEdit);

        return "redirect:";
    }

    @GetMapping("view/{recipeId}")
    public String displayRecipeDetails(Model model, @PathVariable int recipeId) {
        Recipe  recipeToView = recipeRepository.findById(recipeId);
        String title = "View Recipe " + recipeToView.getName() + " (id=" + recipeToView.getId() + ")";

        List<IngredientView> ingredientViews = new ArrayList<>();

        String[] ingredientLines = recipeToView.getIngredientsJson().split("#");

        for (String ingredientLine : ingredientLines){

            if (!ingredientLine.trim().equals(""))
            {
                String[] ingredientData = ingredientLine.split("\\$");

                IngredientView iv = new IngredientView();

                iv.setQuantity(ingredientData[0]);
                iv.setMeasurement(ingredientData[1]);
                iv.setIngredient(ingredientData[2]);

                ingredientViews.add(iv);

            }
        }

        model.addAttribute("title", title );
        model.addAttribute("recipe", recipeToView);
        model.addAttribute("ingredientViews", ingredientViews);

        return "recipes/view";
    }

}

