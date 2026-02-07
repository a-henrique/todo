package com.todolist.todo.dto;

public record CreateTodoCardRequest(String nome, String descricao, int prioridade) {
}