package com.example.demo.todo;

import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import org.springframework.stereotype.Component;

import com.example.demo.todo.dto.CreateTodoInputDto;
import com.example.demo.todo.dto.UpdateTodoInputDto;

import java.util.List;

import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLInputField;
import io.leangen.graphql.annotations.GraphQLMutation;

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

    @GraphQLMutation(name = "createTodo")
    public Todo createTodo(
            @GraphQLInputField CreateTodoInputDto input) {

        return todoService.createTodo(new Todo(input.getTitle(), input.getDescription(), false, input.getDueDate()));
    }

    @GraphQLMutation(name = "updateTodo")
    public Todo updateTodo(
            @GraphQLArgument Long id,
            @GraphQLInputField UpdateTodoInputDto input) {
        return todoService.updateTodo(id,
                new Todo(input.getTitle(), input.getDescription(), input.getCompleted(), input.getDueDate()));
    }

}