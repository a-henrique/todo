package com.todolist.todo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "labels")
public class Label {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    protected Label(){

    }

    public Label(String name){
        this.name = name;
    }

    public Long getId(){
        return id;
    }

    public String getName() {
        return name;
    }


}
