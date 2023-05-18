package com.sajal.onlinebooklibraryapplication.dto;

import com.sajal.onlinebooklibraryapplication.entity.RoleEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@Builder
public class RegisterRequest {
    private String firstName, lastName, email, password, address;
    private List<String> roles;
}
