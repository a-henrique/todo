package com.todolist.todo.service;

import com.todolist.todo.entity.Label;
import com.todolist.todo.repository.LabelRepository;
import org.springframework.stereotype.Service;

@Service
public class LabelService {

    private final LabelRepository labelRepository;

    public LabelService(LabelRepository labelRepository){
        this.labelRepository = labelRepository;
    }

    public Label create(String name){
        Label label = new Label(name);
        return labelRepository.save(label);
    }
}
