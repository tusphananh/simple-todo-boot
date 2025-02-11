package com.example.demo.resolvers;

import com.example.demo.entities.Todo;
import com.example.demo.services.TodoService;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class TodoResolver {

    private final TodoService todoService;

    public TodoResolver(TodoService todoService) {
        this.todoService = todoService;
    }

    @GraphQLQuery(name = "getTodos")
    public List<Todo> getTodos() {
        return todoService.getAllTodos();
    }
    @GraphQLQuery(name = "getTodoById")
    public Todo getTodoById(Long id) {
        return todoService.getTodoById(id);
    }

    @GraphQLQuery(name = "getTodoByUserId")
    public List<Todo> getTodoByUserId(Long userId) {
        return todoService.getTodosByUserId(userId);
    }

    @GraphQLMutation(name = "addTodo")
    public Todo createTodo(String title, String description, LocalDateTime dueDate, Long userId) {
        return todoService.createTodo(title, description, dueDate, userId);
    }

    @GraphQLMutation(name = "updateTodo")
    public Todo updateTodo(Long id, String title, String description, Boolean completed) {
        return todoService.updateTodo(id, title, description, completed);
    }

    @GraphQLMutation(name = "deleteTodo")
    public boolean deleteTodo(Long id) {
        return todoService.deleteTodoById(id);
    }

}
