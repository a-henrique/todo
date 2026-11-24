package com.todolist.todo.controller;

import com.todolist.todo.dto.CreateUserRequest;
import com.todolist.todo.entity.User;
import com.todolist.todo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody CreateUserRequest request){
        return userService.create(request.name(), request.email());
    }
}
