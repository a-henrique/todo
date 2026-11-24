package com.todolist.todo.service;

import com.todolist.todo.entity.User;
import com.todolist.todo.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User create(String name, String email){
        User user = new User(name, email);
        return userRepository.save(user);
    }
}
