package com.wigravy.zoogram.payload.request;

import com.wigravy.zoogram.annotations.PasswordMatches;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@PasswordMatches
public class RegistrationNewUserRequest {
    @Email(message = "Must be a valid email.")
    @NotBlank(message = "Email is required")
    private String email;
    private String firstname;
    private String lastname;
    @NotBlank(message = "Nickname is required")
    private String nickname;
    @NotEmpty(message = "Password is required")
    @Size(min = 8)
    private String password;
    private String confirmPassword;

}
