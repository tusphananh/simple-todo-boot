package com.example.demo.auth;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.user.UserService;
import com.example.demo.user.User;

@Service
public class AuthService {

    private final UserService userService;

    public AuthService(UserService userService) {
        this.userService = userService;
    }

    public boolean authorize(String username, String password) {
        Optional<User> user = userService.findByUsername(username);
        if (user.isPresent() && userService.verifyPassword(user.get(), password)) {
            return true;
        }
        return false;
    }
}