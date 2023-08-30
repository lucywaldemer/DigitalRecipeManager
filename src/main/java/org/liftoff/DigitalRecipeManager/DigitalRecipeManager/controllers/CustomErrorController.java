package org.liftoff.DigitalRecipeManager.DigitalRecipeManager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;


import javax.servlet.http.HttpServletRequest;

@Controller
public class CustomErrorController implements AbstractErrorController {

    @Override
    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        // Get the HTTP status code and message
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        String errorMessage = (String) request.getAttribute("javax.servlet.error.message");

        // Handle different error status codes as needed
        if (statusCode == 404) {
            // Handle 404 Not Found errors
            model.addAttribute("message", "Page not found.");
            return "error";
        } else if (statusCode == 500) {
            // Handle 500 Internal Server Error
            model.addAttribute("message", "Internal Server Error.");
            return "error";
        }

        // Handle other error codes or return a generic error page
        return "error";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}

