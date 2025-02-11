package com.example.demo.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Built-in methods from JpaRepository:
    // - save()
    // - findById()
    // - findAll()
    // - delete()
    // etc.

    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);
}