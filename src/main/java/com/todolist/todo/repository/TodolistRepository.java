package com.todolist.todo.repository;

import com.todolist.todo.entity.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodolistRepository extends JpaRepository<TodoList, Long> {
}
