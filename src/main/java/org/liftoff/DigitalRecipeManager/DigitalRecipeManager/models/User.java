package org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models;

import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;

@Entity
// stores a file name for photos
@Table(name = "users")
public class User extends AbstractEntity {
    // use ID comes from AbstractEntity
// stores the photo containing up to 64 characters
    @Column(nullable = true, length = 64)
    private String photos;
    // allows access to the directory of photos
    @Transient
    public String getPhotosImagePath() {
        if (photos == null) return null;

        return "/user-photos/" + photos;
    }

    @NotNull
    private String username;

    @NotNull
    private String pwHash;

    // helps the password encoded get recognized by the client
    @Autowired
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
// This was from https://stackoverflow.com/questions/43007763/spring-security-encoded-password-gives-me-bad-credentials
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(bCryptPasswordEncoder());
    }

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public User() {}

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
// allows user to upload photos. Saves the name
    public void setPhotos(String fileName) {
    }

    public String getPassword() {
        return pwHash;
    }
}
