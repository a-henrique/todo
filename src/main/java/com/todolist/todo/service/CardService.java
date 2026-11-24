package com.todolist.todo.service;

import com.todolist.todo.entity.Card;
import com.todolist.todo.entity.TodoList;
import com.todolist.todo.repository.CardRepository;
import com.todolist.todo.repository.TodoListRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CardService {
    private final TodoListRepository todoListRepository;
    private final CardRepository cardRepository;

    public CardService(TodoListRepository todoListRepository, CardRepository cardRepository){
        this.todoListRepository = todoListRepository;
        this.cardRepository= cardRepository;
    }

    @Transactional
    public Card create(String title, String description, Long todoListId){
        TodoList todoList = todoListRepository.findById(todoListId)
                .orElseThrow(() -> new EntityNotFoundException("TodoList not found")
                );

        Card card = new Card(title, description, todoList);
        return cardRepository.save(card);
    }

    @Transactional(readOnly = true)
    public List<Card> findByTodoListId(Long todoListId){
        todoListRepository.findById(todoListId)
                .orElseThrow(() -> new EntityNotFoundException("TodoList not found"));

        return cardRepository.findByTodoListId(todoListId);
    }
}
