package org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Entity
public class User extends AbstractEntity {
    // user ID comes from AbstractEntity

    @NotNull
    private String username;

    @NotNull
    private String pwHash;





    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.pwHash = encoder.encode(password);
    }

    public String getUsername() {
        return username;
    }



    public boolean isMatchingPassword(String password) {

        return encoder.matches(password, pwHash);
    }
}