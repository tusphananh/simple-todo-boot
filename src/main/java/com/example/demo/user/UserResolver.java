package com.example.demo.user;

import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import org.springframework.stereotype.Component;

@GraphQLApi
@Component
public class UserResolver {

    UserService userService;

    public UserResolver(UserService userService) {
        this.userService = userService;
    }

    @GraphQLMutation(name = "register", description = "to register user")
    public User register(@GraphQLArgument String username, @GraphQLArgument String firstName,
            @GraphQLArgument String lastName,
            @GraphQLArgument String password) {

        return this.userService.createUser(new User(firstName, lastName, password, username));

    }

}