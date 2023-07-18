package org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models.data;

import org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUsername(String username);
}
