package com.sajal.onlinebooklibraryapplication.dto;

import com.sajal.onlinebooklibraryapplication.entity.RoleEntity;
import jakarta.persistence.*;
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

    private String firstName, lastName, email, password, address;
    private List<String> roles;
}
