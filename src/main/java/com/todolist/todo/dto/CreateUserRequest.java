package com.todolist.todo.dto;

public record CreateUserRequest(
        String nome,
        String email,
        String password
    ){
}
