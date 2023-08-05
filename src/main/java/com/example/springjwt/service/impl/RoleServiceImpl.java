package com.example.springjwt.service.impl;

import com.example.springjwt.entity.Role;
import com.example.springjwt.entity.RoleName;
import com.example.springjwt.repository.IRoleRepository;
import com.example.springjwt.security.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    IRoleRepository roleRepository;

    @Override
    public Optional<Role> findByName(RoleName name) {
        return roleRepository.findByName(name);
    }
}
