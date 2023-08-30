package org.liftoff.DigitalRecipeManager.DigitalRecipeManager.controllers;

import org.liftoff.DigitalRecipeManager.DigitalRecipeManager.data.UserProfileRepository;
import org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models.UserProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/Profile")
public class ProfileController {
    @Autowired
    private UserProfileRepository userProfileRepository;
    private static final Logger logger = LoggerFactory.getLogger(ProfileController.class);

    @GetMapping("/{username}")
    public String viewProfile(@PathVariable String username, Model model) {
        // Log the username
        logger.info("Viewing profile for username: {}", username);

        UserProfile userProfile = userProfileRepository.findByUsername(username);

        // Log the result
        logger.info("userProfile: {}", userProfile);

        if (userProfile != null) {
            model.addAttribute("userProfile", userProfile);
            return "userProfile";
        } else {
            // Handle the case where the user profile is not found for viewing
            model.addAttribute("message", "User profile not found for viewing");
            return "error"; // Return the error view directly
        }
    }

    // Return the profile view template;

    @GetMapping("/{username}/edit")
    public String editProfileForm(@PathVariable String username, Model model) {
        // Retrieve the user profile by username from the repository
        UserProfile userProfile = userProfileRepository.findByUsername(username);

        if (userProfile != null) {
            model.addAttribute("userProfile", userProfile);
            return "profile/edit";
        } else {
            // Handle the case where the user profile is not found for editing
            model.addAttribute("message", "User profile not found for editing");
            return "error"; // Return the error view directly
        }
    }

    @PostMapping("/{username}/edit")
    public String editProfile(@PathVariable String username, @ModelAttribute UserProfile userProfile) {
        // Update the user profile in the repository
        userProfileRepository.save(userProfile);

        // Redirect to the user's profile page
        return "redirect:/profile/" + username;
    }
    @PostMapping("/upload")
    public String uploadProfilePicture(@RequestParam("profilePicture") MultipartFile file, Model model) {
        // Handle the file upload and saving logic here

        // For example, you can save the file to a specific location or database
        // You may also update the user's profile with the new picture

        // Replace {username} with the actual username
        return "redirect:/profile/{username}";
    }

}