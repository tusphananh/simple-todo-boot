package com.example.todo.service;

import com.example.todo.entity.Todo;
import com.example.todo.entity.User;
import com.example.todo.repository.TodoRepository;
import com.example.todo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    // Fetch all todos
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    // Fetch todos for a specific user
    public List<Todo> getTodosByUser(User user) {
        return todoRepository.findByUser(user);
    }

    // Fetch a single todo by ID
    public Todo getTodoById(Long id) {
        return todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found with id: " + id));
    }

    // Create a new todo
    public Todo createTodo(String title, String description, LocalDateTime dueDate, User user) {
        Todo todo = new Todo();
        todo.setTitle(title);
        todo.setDescription(description);
        todo.setDueDate(dueDate);
        todo.setCompleted(false); // Default to not completed
        todo.setUser(user); // Associate the todo with the current user
        return todoRepository.save(todo);
    }

    // Update an existing todo
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

    // Delete a todo by ID
    public boolean deleteTodoById(Long id) {
        Todo todo = getTodoById(id); // Ensure the todo exists
        todoRepository.delete(todo); // Delete the todo
        return true;
    }

    // Delete expired todos (used in the scheduled task)
    public void deleteExpiredTodos(LocalDateTime currentTime) {
        List<Todo> expiredTodos = todoRepository.findByDueDateBeforeAndCompletedFalse(currentTime);
        todoRepository.deleteAll(expiredTodos);
    }
}
