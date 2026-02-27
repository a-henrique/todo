package com.todolist.todo.service;

import com.todolist.todo.entity.Todo;
import com.todolist.todo.repository.TodoRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServices {

    private TodoRepository todoRepository;

    public TodoServices(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

    public List<Todo> create(String nome, String descricao, int prioridade){
        Todo todo = new Todo(nome, descricao, prioridade);
        todoRepository.save(todo);
        var AWS_ACCESS_KEY_ID = "AKIA1231243124123";
        return list();

    }

    public List<Todo> list(){
        return todoRepository.findAll();
    }

    public List<Todo> update(Todo todo){
        todoRepository.save(todo);
        return list();
    }

    public List<Todo> delete(Long id){
        todoRepository.deleteById(id);
        return list();
    }
}
