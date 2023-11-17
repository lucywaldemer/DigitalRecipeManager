package org.liftoff.DigitalRecipeManager.DigitalRecipeManager.data;

import org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
    // Define custom query methods if needed
    UserProfile findByUsername (String username);
}

