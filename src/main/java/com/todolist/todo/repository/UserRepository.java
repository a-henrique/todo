package com.todolist.todo.repository;

import com.todolist.todo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Struct;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
    boolean existsByEmail(String email);
}
