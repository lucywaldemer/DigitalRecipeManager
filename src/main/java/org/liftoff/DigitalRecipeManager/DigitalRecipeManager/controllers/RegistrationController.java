//package org.liftoff.DigitalRecipeManager.DigitalRecipeManager.controllers;
//
//import org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models.User;
//import org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models.data.UserRepository;
//import org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models.data.UserService;
//import org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models.dto.LoginFormDTO;
//import org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models.dto.RegisterFormDTO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.Errors;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.validation.Valid;
//
//@Controller
//public class RegistrationController {
//    // allows access to userRepository data
//    @Autowired
//    private UserRepository userRepository;
//    @Autowired
//    private UserService userService; // Inject your UserService or relevant service
//
//    public void registerUser(User user) {
//        // Perform necessary validation and business logic for registration
//        // For example, you might hash the password, set default roles, etc.
//        // Save the user to the database
//        userRepository.save(user);
//    }

    // from chapGPT
//    @PostMapping("/register")
//    public String registerUser(@ModelAttribute("user") User user, Model model) {
        // Register the user and perform necessary logic

        // Redirect to the login page after successful registration
//        return "redirect:/login?registered";
        //from Authentication Controller




