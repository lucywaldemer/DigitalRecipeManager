package org.liftoff.DigitalRecipeManager.DigitalRecipeManager.controllers;

import org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


public class ProfileController {
    // gets username and displays it in the profile view
    @RequestMapping(value="/profile")
    public String profile(Model model, User user) {
        String usernameForProfile = user.getUsername();
        model.addAttribute("username: ", usernameForProfile);
        return "profile";
    }
}
