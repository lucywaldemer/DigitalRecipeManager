package org.liftoff.DigitalRecipeManager.DigitalRecipeManager.controllers;

import org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProfileController {
    // displays the /profile page
    @RequestMapping(value="/profile")
    public String profile(Model model, User user) {
        String usernameForProfile = user.getUsername();
        model.addAttribute("username", usernameForProfile);
        return "profile";
    }
}