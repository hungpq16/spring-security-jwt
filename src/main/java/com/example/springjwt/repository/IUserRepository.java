package com.example.springjwt.repository;

import com.example.springjwt.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    // Find out if the user is in the DB?
    Optional<User> findByUsername(String name);

    // Check username is in the DB, when I log in
    Boolean existsByUsername(String username);

    // Check username is in the DB, when I log in
    Boolean existsByEmail(String email);
}
