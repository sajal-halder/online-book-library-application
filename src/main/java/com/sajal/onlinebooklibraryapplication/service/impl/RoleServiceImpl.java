package com.sajal.onlinebooklibraryapplication.service.impl;

import com.sajal.onlinebooklibraryapplication.entity.RoleEntity;
import com.sajal.onlinebooklibraryapplication.entity.RoleEnum;
import com.sajal.onlinebooklibraryapplication.exception.RoleDoesNotExistException;
import com.sajal.onlinebooklibraryapplication.repository.RoleRepository;
import com.sajal.onlinebooklibraryapplication.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.sajal.onlinebooklibraryapplication.values.Messages.ROLE_NOT_EXIST;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public RoleEntity addRole(RoleEnum roleName) {
        if(roleRepository.findByRoleName(roleName.name()).isEmpty()){
            RoleEntity role =new RoleEntity();
            role.setRoleName(roleName.name());
         return   roleRepository.save(role);
        }
        return null;
    }

    @Override
    public RoleEntity getRole(String roleName) {

        Optional<RoleEntity> roleEntity = roleRepository.findByRoleName(roleName);
        if(roleEntity.isPresent()){
            return  roleEntity.get();
        }else{
            throw new RoleDoesNotExistException(ROLE_NOT_EXIST);
        }

    }
}
