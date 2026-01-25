package com.todolist.todo.dto;

public record ChangePasswordRequest(String currentPassword, String newPassword) {}
