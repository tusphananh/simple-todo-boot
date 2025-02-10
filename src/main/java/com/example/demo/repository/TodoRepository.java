package com.example.demo.repository;

import com.example.demo.entities.Todo;
import com.example.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    List<Todo> findByUser(User user);

    @Query("SELECT t FROM Todo t WHERE t.dueDate < :dueDate AND t.completed = false")
    List<Todo> findByDueDateBeforeAndCompletedFalse(LocalDateTime dueDate);
}
