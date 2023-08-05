package com.example.springjwt.security;

import com.example.springjwt.entity.Role;
import com.example.springjwt.entity.RoleName;

import java.util.Optional;

public interface IRoleService {
    Optional<Role> findByName(RoleName name);
}
