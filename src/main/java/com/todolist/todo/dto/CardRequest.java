package com.todolist.todo.dto;

public record CardRequest(String title, String description, Long todoListId) {
}
