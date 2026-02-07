package com.todolist.todo.entity;

import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(
        name = "users",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_user_email", columnNames = "email")
        }
)

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(nullable = false, unique = true) // Nao confiar apenas nessa flag para definir a constraint como única, é preciso tratar o erro.
    private String email;

    @Column(nullable = false)
    private String passwordHash;

    private String role;

    private boolean status;

    private LocalDateTime created_at; //

    private LocalDateTime updated_at;

    public User(){

    }

    public User(String nome, String email, String passwordHash){
        this.nome = nome;
        this.email = email; // check
        this.role = "user"; // check
        this.status = true;
        this.passwordHash = passwordHash;
        this.created_at = LocalDateTime.now();
        this.updated_at = LocalDateTime.now();
    }

    public Long getId(){
        return id;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String role(){
        return role;
    }

    public void setRole(String role){
        this.role = role;
    }

    public String getPasswordHash(){
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash){
        this.passwordHash = passwordHash;
    }

    public boolean getStatus(){
        return status;
    }

    public void setStatus(boolean status){
        this.status = status;
    }

    public LocalDateTime getCreated_at(){
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at){
        this.created_at = created_at;
    }

    public LocalDateTime getUpdated_at(){
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at){
        this.updated_at = updated_at;
    }

}
