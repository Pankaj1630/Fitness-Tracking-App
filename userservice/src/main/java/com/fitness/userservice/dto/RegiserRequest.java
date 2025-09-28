package com.fitness.userservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegiserRequest {
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email")
    private String email;
    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be atleast 5 character")
    private String password;
    @NotBlank(message = "First name can not be blank")
    private String firstName;
    @NotBlank
    @NotBlank(message = "Last name can not be blank")
    private String lastName;


}
