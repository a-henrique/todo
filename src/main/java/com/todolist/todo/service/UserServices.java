package com.todolist.todo.service;

import com.todolist.todo.entity.User;
import com.todolist.todo.repository.UserRepository;
import org.aspectj.apache.bcel.generic.RET;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices {

    private UserRepository userRepository;

    public UserServices(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public User getById(Long id){
        return userRepository.getReferenceById(id);
    }

    public List<User> listUsers(){
        return userRepository.findAll();
    }

    public void disableUser(Long id) {
        User user = userRepository.getReferenceById(id);
        if(user.getStatus()){
            user.setStatus(false);
        }
        userRepository.save(user);
    }

    public void enableUser(Long id){
        User user = userRepository.getReferenceById(id);
        if (!user.getStatus()){
            user.setStatus(true);
        }
        userRepository.save(user);
    }
}
