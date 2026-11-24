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

    @Transactional
    public Card complete(Long todoListId, Long cardId){
        Card card = cardRepository.findById(cardId)
                .orElseThrow(() -> new EntityNotFoundException("Card Not Found")
                );

        if (!card.getTodoList().getId().equals(todoListId)){
            throw new EntityNotFoundException("Card does not belong to this TodoList");
        }

        card.complete();

        return card;
    }

    @Transactional
    public Card reopen (Long todoListId, Long cardId){
        Card card = cardRepository.findById(cardId)
                .orElseThrow(() -> new EntityNotFoundException("Card not found"));

        if(!card.getTodoList().getId().equals(todoListId)){
            throw new EntityNotFoundException("Card does not belog to this TodoList");
        }

        card.reopen();
        return card;
    }
}
