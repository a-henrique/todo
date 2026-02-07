package com.todolist.todo.controller;

import com.todolist.todo.dto.CreateTodoCardRequest;
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
    public List<Todo> create(@RequestBody CreateTodoCardRequest todoBody){
        return todoServices.create(todoBody.nome(), todoBody.descricao(), todoBody.prioridade());
    }

    @GetMapping("/list")
    public List<Todo> list(){
        return todoServices.list();
    }

    @PutMapping("/update")
    public List<Todo> update(@RequestBody Todo todo){
        return todoServices.update(todo);
    }

    @DeleteMapping("/{id}")
    public List<Todo> delete(@PathVariable Long id){
        return todoServices.delete(id);
    }
}
