package com.example.demo.todo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateTodoInputDto extends CreateTodoInputDto {
    private Boolean completed;

}
