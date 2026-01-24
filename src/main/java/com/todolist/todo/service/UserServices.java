package com.todolist.todo.service;

import com.todolist.todo.entity.User;
import com.todolist.todo.repository.UserRepository;

import java.util.List;

public class UserServices {

    private UserRepository userRepository;

    public UserServices(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void createUser(User user){
        userRepository.save(user);
    }

    public List<User> listUsers(){
        return userRepository.findAll();
    }

    public void disableUser(User user) {
        if (user.getStatus()) {
            user.setStatus(false);
        } else {
            user.setStatus(true);
        }
    }

}
