package com.todolist.todo.dto;

public record CardResponse(Long id, String title, String description, boolean completed) {
}
