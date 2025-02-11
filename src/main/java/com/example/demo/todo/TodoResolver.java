package com.example.demo.todo;

import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import org.springframework.stereotype.Component;

import java.util.List;

@GraphQLApi
@Component
public class TodoResolver {
    private final TodoService todoService;

    public TodoResolver(TodoService todoService) {
        this.todoService = todoService;
    }

    @GraphQLQuery(name = "todos")
    public List<Todo> getTodos() {
        return todoService.getAllTodos();
    }

}