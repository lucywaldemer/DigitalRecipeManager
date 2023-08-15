package org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models;

import org.liftoff.DigitalRecipeManager.DigitalRecipeManager.data.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RecipeService {
    @Autowired
    private static RestTemplate template = new RestTemplate();
    @Autowired
    RecipeRepository recipeRepository;
    public static Object[] findRecipeByMeal() {
        return template.getForObject("https://www.themealdb.com/api/json/v1/1/search.php?s=", Object[].class);
    }
    public static Ingredient[] findAllIngredients() {
        return template.getForObject("www.themealdb.com/api/json/v1/1/list.php?i=list", Ingredient[].class);
    }
}
