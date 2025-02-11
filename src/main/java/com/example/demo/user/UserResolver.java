package com.example.demo.user;

import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import org.springframework.stereotype.Component;

@GraphQLApi
@Component
public class UserResolver {

    @GraphQLQuery(name = "getUsers", description = "to get all the users")
    public Boolean getUsers() {
        return true;
    }

}