package org.liftoff.DigitalRecipeManager.DigitalRecipeManager.controllers;
import org.liftoff.DigitalRecipeManager.DigitalRecipeManager.data.UserRepository;
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
import java.util.Optional;

@Controller

public class HomeController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    AuthenticationController authenticationController;

    @GetMapping
    public String index(Model model,HttpSession session){


        User user = authenticationController.getUserFromSession(session);

        if (user!=null) {
            model.addAttribute("username", user.getUsername());
        }

        return "home";
    }



}