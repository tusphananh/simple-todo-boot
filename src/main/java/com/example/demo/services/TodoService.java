package com.example.demo.services;

import com.example.demo.entities.Todo;
import com.example.demo.entities.User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public interface TodoService {
    List<Todo> getAllTodos();

    List<Todo> getTodosByUserId(Long userId);

    Todo getTodoById(Long id);

    Todo createTodo(String title, String description, LocalDateTime dueDate, Long userId);

    Todo updateTodo(Long id, String title, String description, Boolean completed);

    boolean deleteTodoById(Long id);

    void deleteExpiredTodos(LocalDateTime currentTime);
}
