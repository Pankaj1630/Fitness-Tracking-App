package com.fitness.userservice.dto;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class UserResponse {
    private Integer id;
    private String email;
    @Column(nullable = false)
    private String password;
    private String firstName;
    private String lastName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
