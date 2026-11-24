package com.todolist.todo.repository;

import com.todolist.todo.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardRepository extends JpaRepository<Card, Long> {

    List<Card> findByTodoListId(Long todoListId);
}
