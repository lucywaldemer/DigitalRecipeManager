package org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models.data;

import org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository; // Inject your UserRepository

    public void registerUser(User user) {
        // Perform necessary validation and business logic for registration
        // For example, you might hash the password, set default roles, etc.

        // Save the user to the database
        userRepository.save(user);
    }
}

