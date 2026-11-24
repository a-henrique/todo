package com.todolist.todo.controller;

import com.todolist.todo.dto.CardRequest;
import com.todolist.todo.dto.CardResponse;
import com.todolist.todo.entity.Card;
import com.todolist.todo.entity.TodoList;
import com.todolist.todo.service.CardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo-lists")
public class CardController {
    private final CardService cardService;

    public CardController(CardService cardService){
        this.cardService = cardService;
    }

    @PostMapping("{todoListId}/cards")
    public CardResponse create(@PathVariable Long todoListId, @RequestBody CardRequest request){
        Card card = cardService.create(
                request.title(),
                request.description(),
                todoListId
        );
        return new CardResponse(
                card.getId(),
                card.getTitle(),
                card.getDescription(),
                card.isCompleted()
        );
    }

    @GetMapping("/{todoListId}/cards")
    public List<CardResponse> findByTodoListId(@PathVariable Long todoListId){
        return cardService.findByTodoListId(todoListId)
                .stream()
                .map(card -> new CardResponse(
                        card.getId(),
                        card.getTitle(),
                        card.getDescription(),
                        card.isCompleted()
                ))
                .toList();
    }

}
