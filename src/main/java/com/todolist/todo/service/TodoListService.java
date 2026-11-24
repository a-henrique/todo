package com.todolist.todo.service;

import com.todolist.todo.entity.TodoList;
import com.todolist.todo.entity.User;
import com.todolist.todo.repository.TodoListRepository;
import com.todolist.todo.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TodoListService {
    private final TodoListRepository todoListRepository;
    private final UserRepository userRepository;

    public TodoListService(TodoListRepository todoListRepository, UserRepository userRepository){
        this.todoListRepository = todoListRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public TodoList create(String title, Long userId){
        User user = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("User not found"));

        TodoList todoList = new TodoList(title, user);

        return todoListRepository.save(todoList);
    }

    @Transactional(readOnly = true)
    public List<TodoList> findByUserId(Long userId){
        return todoListRepository.findByUserId(userId);
    }

    @Transactional(readOnly = true)
    public TodoList findById(Long id){
        return todoListRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(("TodoList not found")));
    }
}
