package com.example.demo.config;

import com.example.demo.resolvers.TodoResolver;
import graphql.GraphQL;
import io.leangen.graphql.GraphQLSchemaGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GraphQLConfig {

    private final TodoResolver todoResolver;

    public GraphQLConfig(TodoResolver todoResolver) {
        this.todoResolver = todoResolver;
    }

    @Bean
    public GraphQL graphQL() {
        return GraphQL.newGraphQL(
                new GraphQLSchemaGenerator()
                        .withOperationsFromSingleton(todoResolver) // ✅ Registers queries/mutations
                        .generate()
        ).build();
    }
}
