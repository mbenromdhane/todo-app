package com.todo.todoapp.repositories;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import com.todo.todoapp.models.TodoItem;

public interface TodoRepository extends CrudRepository<TodoItem, Long> {

    Object findAll(Sort by);
}