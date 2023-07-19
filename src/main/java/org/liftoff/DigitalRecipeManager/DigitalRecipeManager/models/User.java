package org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models;

import com.sun.istack.NotNull;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
// stores a file name for photos
@Table(name = "users")
public class User extends AbstractEntity {
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
}
