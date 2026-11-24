package com.todolist.todo.dto;

public record UserResponse(
        Long id,
        String name,
        String email
) {

}
