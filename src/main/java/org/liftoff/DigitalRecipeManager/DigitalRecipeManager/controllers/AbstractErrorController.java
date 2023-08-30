package org.liftoff.DigitalRecipeManager.DigitalRecipeManager.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

public interface AbstractErrorController extends ErrorController {
    @RequestMapping("/error")
    String handleError(HttpServletRequest request, Model model);

    String getErrorPath();
}
