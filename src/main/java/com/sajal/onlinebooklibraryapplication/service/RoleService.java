package com.sajal.onlinebooklibraryapplication.service;

import com.sajal.onlinebooklibraryapplication.entity.RoleEntity;


public interface RoleService {

    public RoleEntity addRole(String roleName);
    public RoleEntity getRole(String roleName);


}
