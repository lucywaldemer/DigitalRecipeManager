package org.liftoff.DigitalRecipeManager.DigitalRecipeManager.controllers;

import org.liftoff.DigitalRecipeManager.DigitalRecipeManager.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    @Autowired
    private UserRepository repo;

}

