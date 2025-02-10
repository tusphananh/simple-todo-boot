package com.example.demo.resolvers;

import com.example.demo.entities.Todo;
import com.example.demo.entities.User;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.DgsMutation;
import com.example.demo.services.TodoService;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@DgsComponent
@RequiredArgsConstructor
public class TodoResolver {

    private final TodoService todoService;

    @DgsQuery
    public List<Todo> getTodos() {
        return todoService.getAllTodos();
    }

    @DgsQuery
    public Todo getTodoById(Long id) {
        return todoService.getTodoById(id);
    }

    @DgsMutation
    public Todo createTodo(String title, String description, LocalDateTime dueDate, User user) {
        return todoService.createTodo(title, description, dueDate, user);
    }

    @DgsMutation
    public Todo updateTodo(Long id, String title, String description, Boolean completed) {
        return todoService.updateTodo(id, title, description, completed);
    }

    @DgsMutation
    public boolean deleteTodo(Long id) {
        return todoService.deleteTodoById(id);
    }
}
