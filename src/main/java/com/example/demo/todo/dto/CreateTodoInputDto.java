package com.example.demo.todo.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateTodoInputDto {
    private Boolean completed;

    @NotBlank
    private String title;

    private String description;

    private LocalDateTime dueDate;
}
