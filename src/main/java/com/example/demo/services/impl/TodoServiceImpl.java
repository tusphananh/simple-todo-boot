package com.example.demo.services.impl;

import com.example.demo.entities.Todo;
import com.example.demo.entities.User;
import com.example.demo.repository.TodoRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    @Override
    public List<Todo> getTodosByUserId(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return todoRepository.findByUser(user);
    }

    @Override
    public Todo getTodoById(Long id) {
        return todoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Todo not found with id:" + id));
    }

    @Override
    public Todo createTodo(String title, String description, LocalDateTime dueDate, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Todo todo = new Todo();
        todo.setTitle(title);
        todo.setDescription(description);
        todo.setDueDate(dueDate);
        todo.setCompleted(false); // Default to not completed
        todo.setUser(user); // Associate the todo with the current user
        return todoRepository.save(todo);
    }

    @Override
    public Todo updateTodo(Long id, String title, String description, Boolean completed) {
        Todo todo = getTodoById(id); // Fetch the existing todo

        if (title != null) {
            todo.setTitle(title);
        }
        if (description != null) {
            todo.setDescription(description);
        }
        if (completed != null) {
            todo.setCompleted(completed);
        }

        return todoRepository.save(todo); // Save the updated todo
    }

    @Override
    public boolean deleteTodoById(Long id) {
        Todo todo = getTodoById(id); // Ensure the todo exists
        todoRepository.delete(todo); // Delete the todo
        return true;
    }

    @Override
    public void deleteExpiredTodos(LocalDateTime currentTime) {
        List<Todo> expiredTodos = todoRepository.findByDueDateBeforeAndCompletedFalse(currentTime);
        todoRepository.deleteAll(expiredTodos);
    }
}
