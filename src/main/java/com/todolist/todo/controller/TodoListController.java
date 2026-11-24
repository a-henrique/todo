package com.todolist.todo.controller;

import com.todolist.todo.dto.CreateTodoListRequest;
import com.todolist.todo.entity.TodoList;
import com.todolist.todo.service.TodoListService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo-lists")
public class TodoListController {

    private TodoListService todoListService;

    public TodoListController(TodoListService todoListService){
        this.todoListService = todoListService;
    }

    @PostMapping("/users/{userId}")
    @ResponseStatus(HttpStatus.CREATED)
    public TodoList createTodoList(@PathVariable Long userId, @RequestBody CreateTodoListRequest request){
        return todoListService.create(request.title(), userId);
    }

    @GetMapping("/users/{userId}")
    public List<TodoList> findByUserId(@PathVariable Long userId){
        return todoListService.findByUserId(userId);
    }
}
