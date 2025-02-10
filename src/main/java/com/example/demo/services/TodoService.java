package com.example.demo.services;

import com.example.demo.entities.Todo;
import com.example.demo.entities.User;
import java.time.LocalDateTime;
import java.util.List;

public interface TodoService {
    List<Todo> getAllTodos();

    List<Todo> getTodosByUser(User user);

    Todo getTodoById(Long id);

    Todo createTodo(String title, String description, LocalDateTime dueDate, User user);

    Todo updateTodo(Long id, String title, String description, Boolean completed);

    boolean deleteTodoById(Long id);

    void deleteExpiredTodos(LocalDateTime currentTime);
}
