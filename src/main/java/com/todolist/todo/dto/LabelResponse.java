package com.todolist.todo.dto;

import com.todolist.todo.entity.Label;

public record LabelResponse(Long id, String name) {
    public static LabelResponse from(Label label){
        return new LabelResponse(
                label.getId(),
                label.getName()
        );
    }
}
