package com.todolist.todo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "todo_lists")
public class TodoList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    protected TodoList(){}

    public TodoList(String title, User user){
        this.title = title;
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public User getUser() {
        return user;
    }

    public Long getId() {
        return id;
    }
}
