package org.liftoff.DigitalRecipeManager.DigitalRecipeManager.controllers;
import org.liftoff.DigitalRecipeManager.DigitalRecipeManager.data.UserRepository;
import org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models.RandomRecipe;
import org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models.Recipe;
import org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models.RecipeService;
import org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    AuthenticationController authenticationController;
    @Autowired
    private RecipeService recipeService;

    @GetMapping
    public String index(Model model,HttpSession session){


        User user = authenticationController.getUserFromSession(session);

        if (user!=null) {
            model.addAttribute("username", user.getUsername());

        }
        RandomRecipe randomRecipe = recipeService.getRandomRecipe();

        if (randomRecipe != null) {
            model.addAttribute("randomRecipe", randomRecipe);
        } else {
            // Handle the case where a random recipe could not be retrieved
            model.addAttribute("randomRecipe", new RandomRecipe()); // Provide a default recipe or handle it as needed
        }

        return "home";
    }

}