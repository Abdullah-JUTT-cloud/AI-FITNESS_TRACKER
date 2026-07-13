package com.fitness.userservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
public class UserResponse {
    private String id;

    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Invalid Email Format!~")
    private String email;

    private String firstName;

    private String lastName;

    @NotBlank(message = "password cannot be empty")
    @Size(min=6,message = "Password must have atleast 6 characters")
    private String password;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
