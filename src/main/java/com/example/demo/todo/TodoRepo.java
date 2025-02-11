package com.example.demo.todo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TodoRepo extends JpaRepository<Todo, Long> {
    List<Todo> findByUserId(Long userId);

    List<Todo> findByCompleted(boolean completed);

    List<Todo> findByUserIdAndCompleted(Long userId, boolean completed);

    void deleteByUserId(Long userId);
}