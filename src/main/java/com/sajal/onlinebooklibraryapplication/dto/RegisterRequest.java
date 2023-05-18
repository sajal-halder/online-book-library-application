package com.sajal.onlinebooklibraryapplication.dto;

import com.sajal.onlinebooklibraryapplication.entity.RoleEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    @NotEmpty(message = "firstName is required")
    private String firstName;
    @NotEmpty(message = "lastName is required")
    private String lastName;
    @NotEmpty(message = "email is required")
    private String email;
    @NotEmpty(message = "password is required")
    private String password;
    @NotEmpty(message = "address is required")
    private String  address;
    @NotEmpty(message = "roles is required")
    private List<String> roles;
}
