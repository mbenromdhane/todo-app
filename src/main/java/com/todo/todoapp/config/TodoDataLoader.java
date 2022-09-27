package com.todo.todoapp.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.todo.todoapp.models.TodoItem;
import com.todo.todoapp.repositories.TodoRepository;

@Component
public class TodoDataLoader implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(TodoDataLoader.class);

    @Autowired
    TodoRepository todoRepository;

    @Override
    public void run(String... args) throws Exception {
        loadSeedData();
    }

    private void loadSeedData() {
        if (todoRepository.count() == 0) {
            TodoItem todoItem1 = new TodoItem("Todo 1");
            TodoItem todoItem2 = new TodoItem("Todo 2");
            TodoItem todoItem3 = new TodoItem("Todo 3");

            todoRepository.save(todoItem1);
            todoRepository.save(todoItem2);
            todoRepository.save(todoItem3);
        }

        logger.info("Number of TodoItems: {}", todoRepository.count());
    }

}