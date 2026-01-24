package com.todolist.todo.controller;

import com.todolist.todo.entity.Todo;
import com.todolist.todo.service.TodoServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private TodoServices todoServices;

    public TodoController(TodoServices todoServices){
        this.todoServices = todoServices;
    }

    @PostMapping("/create")
    List<Todo> create(@RequestBody Todo todo){
        return todoServices.create(todo);
    }

    @GetMapping("/list")
    List<Todo> list(){
        return todoServices.list();
    }

    @PutMapping("/update")
    List<Todo> update(@RequestBody Todo todo){
        return todoServices.update(todo);
    }

    @DeleteMapping("{id}")
    List<Todo> delete(@PathVariable Long id){
        return todoServices.delete(id);
    }
}
