package com.todolist.todo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "cards")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String description;

    @Column(nullable = false)
    private boolean completed = false;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "todo_list_id", nullable = false)
    private TodoList todoList;

    protected Card (){

    }

    public Card (String title, String description, TodoList todoList){
        this.title = title;
        this.description = description;
        this.todoList = todoList;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted(){
        return completed;
    }

    public TodoList getTodoList() {
        return todoList;
    }

    public void complete(){
        this.completed = true;
    }

    public void reopen(){
        this.completed = false;
    }
}
