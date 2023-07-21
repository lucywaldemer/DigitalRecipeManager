package org.liftoff.DigitalRecipeManager.DigitalRecipeManager.configuration;

import com.javadevjournal.jpa.entities.UserEntity;
import com.javadevjournal.jpa.repository.UserRepository;
import org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models.User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
            UserDetails user = User.withUsername(user.getUsername()).password(user.getPassword()).authorities("USER").build();
            return user;
    }
}
