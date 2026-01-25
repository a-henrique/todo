package com.todolist.todo.controller;


import com.todolist.todo.entity.User;
import com.todolist.todo.service.UserServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserServices userServices;

    public UserController(UserServices userServices){
        this.userServices = userServices;
    }

    @PostMapping("/create")
    public User createUser(@RequestBody User user){
        return userServices.createUser(user);
    }

    @GetMapping("/list/{id}")
    public User listUserById(@PathVariable Long id){
        return userServices.getById(id);
    }

    @GetMapping("/list")
    public List<User> listUsers(){
        return userServices.listUsers();
    }

    @PatchMapping("/disable/{id}")
    public void disableUser(@PathVariable Long id){
        userServices.disableUser(id);
    }

    @PatchMapping("/enable/{id}")
    public void enableUser(@PathVariable Long id){
        userServices.enableUser(id);
    }

    @DeleteMapping("/delete/{id}")
    public void removeUser(@PathVariable Long id){
        userServices.deleteUser(id);
    }
}
