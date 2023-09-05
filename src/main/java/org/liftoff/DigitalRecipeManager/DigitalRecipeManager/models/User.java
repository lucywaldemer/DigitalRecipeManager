package org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;
import java.util.List;


@Entity
@Table(name= "user", schema= "DigitalRecipeManager")
public class User extends AbstractEntity {
    // user ID comes from AbstractEntity
//    @JoinColumn(name="User")
//    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
//    private UserProfile userProfile;
    @NotNull
    private String username;

    @NotNull
    private String pwHash;
    @NotBlank
    private String email;
    private String bio;
    private byte[] profilePicture;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public User() {
    }

    public User(String username, String pwHash, String email, String profilePicture, String firstName, String lastName, String bio) {
        this.username = username;
        this.pwHash = pwHash;
        this.email = email;
        this.profilePicture = profilePicture.getBytes();
        this.firstName = firstName;
        this.lastName = lastName;
        this.bio= bio;
    }

    //    public UserProfile getUserProfile() {
//        return userProfile;
//    }
//    public void setUserProfile(UserProfile userProfile) {
//        this.userProfile = userProfile;
//    }

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

    public String getEmail() {
        return email;
    }

    public String getPwHash() {
        return pwHash;
    }

    public byte[] getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(byte[] profilePicture) {
        // Check if the provided byte array is not null and its length is within the allowed size
        if (profilePicture != null && profilePicture.length <= (3 * 1024 * 1024)) { // 3MB in bytes
            this.profilePicture = profilePicture;
        } else {
            // Handle the case where the provided image is too large
            // You can throw an exception, log an error, or take appropriate action
            // For example:
            throw new IllegalArgumentException("Profile picture size exceeds the allowed limit (3MB).");
        }
    }
    // Define a method to validate the file format based on the file extension
    @NotNull
    private boolean isValidImageFileFormat(String fileExtension) {
        // You can define a list of allowed file extensions (e.g., "jpg", "png", "jpeg", etc.)
        // and check if the provided file extension is in the list
        List<String> allowedExtensions = Arrays.asList("jpg", "jpeg", "png");
        return allowedExtensions.contains(fileExtension.toLowerCase()); // Convert to lowercase for case-insensitive check
    }



    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBio() {
        return bio;
    }

}