package com.todolist.todo.controller;


import com.todolist.todo.dto.ChangePasswordRequest;
import com.todolist.todo.dto.CreateUserRequest;
import com.todolist.todo.entity.User;
import com.todolist.todo.service.UserServices;
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
    public boolean createUser(@RequestBody CreateUserRequest body){
        return userServices.createUser(body.nome(), body.email(), body.password());
    }

    @GetMapping("/{id}/list")
    public User listUserById(@PathVariable Long id){
        return userServices.getById(id);
    }

    @GetMapping("/list")
    public List<User> listUsers(){
        return userServices.listUsers();
    }

    @PatchMapping("/{id}/disable")
    public void disableUser(@PathVariable Long id){
        userServices.disableUser(id);
    }

    @PatchMapping("/{id}/enable")
    public void enableUser(@PathVariable Long id){
        userServices.enableUser(id);
    }

    @DeleteMapping("/{id}/delete")
    public void removeUser(@PathVariable Long id){
        userServices.deleteUser(id);
    }

    @PatchMapping("/{id}/change-password")
    public void changePassword(@PathVariable Long id, @RequestBody ChangePasswordRequest body){
        userServices.changePassword(id, body.currentPassword(), body.newPassword());
    }

    @GetMapping("/email/{email}")
    public User getByEmail(@PathVariable String email){
        return userServices.getByEmail(email);
    }

}
