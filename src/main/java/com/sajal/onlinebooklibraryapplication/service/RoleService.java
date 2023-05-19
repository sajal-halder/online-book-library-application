package com.sajal.onlinebooklibraryapplication.service;

import com.sajal.onlinebooklibraryapplication.entity.RoleEntity;
import com.sajal.onlinebooklibraryapplication.entity.RoleEnum;


public interface RoleService {

    public RoleEntity addRole(RoleEnum role);
    public RoleEntity getRole(String roleName);


}
