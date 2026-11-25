package com.todolist.todo.repository;

import com.todolist.todo.entity.Label;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LabelRepository extends JpaRepository<Label, Long> {

}
