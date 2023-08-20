package org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Service
public class RecipeService {

    private static final String API_BASE_URL = "https://www.themealdb.com/api/json/v1/1/";
    private RestTemplate restTemplate;

    @Autowired
    public RecipeService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Recipe searchRecipeByName(String recipeName) {
        String apiUrl = API_BASE_URL + "search.php?s=" + recipeName;
        RecipeResponse response = restTemplate.getForObject(apiUrl, RecipeResponse.class);

        if (response != null && response.getMeals() != null && !response.getMeals().isEmpty()) {
            return response.getMeals().get(0); // Assuming you want the first result
        }

        return null; // Recipe not found
    }

    public RandomRecipe getRandomRecipe() {
        try {
            // Construct the complete API URL for a single random recipe
            String apiUrl = API_BASE_URL + "random.php";

            // Fetch a single random recipe from the API
            RandomRecipeResponse response = restTemplate.getForObject(apiUrl, RandomRecipeResponse.class);

            if (response != null && response.getMeals() != null && !response.getMeals().isEmpty()) {
                return response.getMeals().get(0); // Assuming you want the first random recipe
            }

            return null; // Random recipe not found
        } catch (Exception e) {
            // Handle API request error or other exceptions
            // Log and return null or a default random recipe
            e.printStackTrace();
            return null;
        }
    }
}
