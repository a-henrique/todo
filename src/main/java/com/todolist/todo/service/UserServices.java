package com.todolist.todo.service;

import com.todolist.todo.entity.User;
import com.todolist.todo.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserServices(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public boolean createUser(String nome, String email, String password){
        if(userRepository.existsByEmail(email)){
            throw new RuntimeException("Email já cadastrado");
        };
        User user = new User(nome, email, password);
        String passwordHashed = passwordEncoder.encode(password);
        save(user);
        return true;
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
        save(user);
    }

    public void enableUser(Long id){
        User user = userRepository.getReferenceById(id);
        if (!user.getStatus()){
            user.setStatus(true);
        }
        save(user);
    }

    public void deleteUser(Long id){
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
        } else {
            throw new RuntimeException("Id não encontrado");
        }
    }

    public void changePassword(Long id, String currentPassword, String newPassword){
        User user = userRepository.getReferenceById(id);
        if(user.getPasswordHash().equals(currentPassword)){
            user.setPasswordHash(newPassword);
        } else {
            throw new RuntimeException("Informe a senha atual");
        }
        save(user);
    }

    String password = "122344";
    public User save(User user){
         return userRepository.save(user);
    }

    public User getByEmail(String email){
        User user = userRepository.findByEmail(email);
        return user;
    }
}
