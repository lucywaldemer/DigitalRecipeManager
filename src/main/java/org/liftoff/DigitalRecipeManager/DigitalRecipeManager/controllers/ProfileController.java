package org.liftoff.DigitalRecipeManager.DigitalRecipeManager.controllers;

import org.liftoff.DigitalRecipeManager.DigitalRecipeManager.data.UserRepository;
import org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static java.lang.Byte.parseByte;

@Controller
@RequestMapping(value= "Profile")
public class ProfileController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationController authenticationController;

    @GetMapping("")
    public String Profile(Model model, HttpSession session) {
        User user = authenticationController.getUserFromSession(session);
        model.addAttribute("First name", user.getFirstName());
        model.addAttribute("username", user.getUsername());
        model.addAttribute("Bio", user.getBio());
        model.addAttribute("Profile picture", user.getProfilePicture());
        model.addAttribute("user", user);
        return "profile";
    }

    @PostMapping("/uploadProfilePicture")
    public String uploadProfilePicture(@RequestParam("file") MultipartFile file, HttpSession session) {
        User user = authenticationController.getUserFromSession(session);

        try {
            // Check if the uploaded file is not empty
            if (!file.isEmpty()) {
                // Check if the uploaded file is a valid image format
                String fileExtension = getFileExtension(file.getOriginalFilename());
                if (!isValidImageFileFormat(fileExtension)) {
                    // Handle the case where the uploaded file is not a valid image
                    throw new IllegalArgumentException("Invalid image format. Only jpg, jpeg, and png are allowed.");
                }

                // Check if the uploaded file size is within the allowed limit (3MB)
                if (file.getSize() > (3 * 1024 * 1024)) {
                    // Handle the case where the uploaded file size exceeds the limit
                    throw new IllegalArgumentException("Profile picture size exceeds the allowed limit (3MB).");
                }

                // Update the user's profile picture and save it using the repository
                byte[] profilePicture = file.getBytes();
                user.setProfilePicture(profilePicture);
                userRepository.save(user);
            }
        } catch (IOException e) {
            // Handle the exception
        }

        return "redirect:/Profile"; // Redirect back to the profile page
    }

    @GetMapping("/profilePicture")
    public ResponseEntity<byte[]> getProfilePicture(HttpSession session) {
        User user = authenticationController.getUserFromSession(session);
        if (user.getProfilePicture() != null) {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG); // Set the content type appropriately

            return new ResponseEntity<>(user.getProfilePicture(), headers, HttpStatus.OK);
        } else {
            // Return a default image or handle this case as needed
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



    // Define a method to validate the file format based on the file extension
    private boolean isValidImageFileFormat(String fileExtension) {
        List<String> allowedExtensions = Arrays.asList("jpg", "jpeg", "png");
        return allowedExtensions.contains(fileExtension.toLowerCase());
    }

    private String getFileExtension(String fileName) {
        int lastIndex = fileName.lastIndexOf('.');
        if (lastIndex >= 0 && lastIndex < fileName.length() - 1) {
            return fileName.substring(lastIndex + 1).toLowerCase();
        }
        return "";
    }
}

