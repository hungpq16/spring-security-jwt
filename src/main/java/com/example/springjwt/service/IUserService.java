package com.example.springjwt.security;

import com.example.springjwt.entity.User;

import java.util.Optional;

public interface IUserService {
    // Find out if the user is in the DB?
    Optional<User> findByUsername(String name);

    // Check username is in the DB, when I log in
    Boolean existsByUsername(String username);

    // Check username is in the DB, when I log in
    Boolean existsByEmail(String email);

    // SignIn username to DB
    User save(User user);
}
