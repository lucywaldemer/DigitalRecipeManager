//package org.liftoff.DigitalRecipeManager.DigitalRecipeManager.controllers;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@Controller
//public class LogInController {
//
//    @GetMapping
//    public String displayClientForm (Model model) {
//        return "serviceSelection";
//    }
//
//    @PostMapping
//    public String processClientForm(@RequestParam String chefType, Model model) {
//        Object newClient;
//        newClient.setAppropriateChefClothes(chefType);
//        model.addAttribute("client" , newClient);
//
//        return "menu";
//    }
//}
