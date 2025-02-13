package com.example.demo.auth;

import org.springframework.stereotype.Component;

import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;

@GraphQLApi
@Component
public class AuthResolver {

    private final AuthService authService;

    public AuthResolver(AuthService authService) {
        this.authService = authService;
    }

    @GraphQLMutation(name = "login", description = "to login user")
    public boolean login(
            @GraphQLArgument(name = "username") String username,
            @GraphQLArgument(name = "password") String password) {
        return authService.authorize(username, password);
    }
}
