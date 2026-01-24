package com.todolist.todo.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

public class Todo {

    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define que "id" é a coluna de identificacao da entidade
    private Long id;
    private String nome;
    private String descricao;
    private boolean realizado;
    private int prioridade;

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getDescricao(){
        return descricao;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public boolean getRealizado(){
        return realizado;
    }

    public void setRealizado(boolean realizado){
        this.realizado = realizado;
    }

    public int getPrioridade(){
        return prioridade;
    }

    public void setPrioridade(int prioridade){
        this.prioridade = prioridade;
    }

}
