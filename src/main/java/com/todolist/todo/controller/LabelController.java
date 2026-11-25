package com.todolist.todo.controller;

import com.todolist.todo.dto.CreateLabelRequest;
import com.todolist.todo.dto.LabelResponse;
import com.todolist.todo.entity.Label;
import com.todolist.todo.service.LabelService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/labels")
public class LabelController {
    private final LabelService labelService;

    public LabelController(LabelService labelService){
        this.labelService = labelService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LabelResponse create(@Valid @RequestBody CreateLabelRequest request){
        Label label = labelService.create(request.name());
        return LabelResponse.from(label);
    }
}
