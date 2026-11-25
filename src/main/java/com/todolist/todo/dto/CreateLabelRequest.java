package com.todolist.todo.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateLabelRequest(@NotBlank(message = "Label name required") String name) {
}
