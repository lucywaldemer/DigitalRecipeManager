package org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models.dto;

public class RegisterFormDTO extends org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models.dto.LoginFormDTO {

    private String username;
    private String verifyPassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
    }
}