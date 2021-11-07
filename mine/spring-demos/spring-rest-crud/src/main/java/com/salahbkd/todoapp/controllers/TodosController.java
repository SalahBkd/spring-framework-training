package com.salahbkd.todoapp.controllers;


import com.salahbkd.todoapp.entity.Todo;
import com.salahbkd.todoapp.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TodosController {

    private TodoService todoService;

    @Autowired
    public TodosController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/todos")
    public List<Todo> getTodos() {
        return this.todoService.getTodos();
    }


    @GetMapping("/todos/{todoId}")
    public Optional<Todo> getTodo(@PathVariable Integer todoId) {
        return this.todoService.getTodo(todoId);
    }

    @PostMapping("/todos")
    public void addTodo(@RequestBody Todo todo) {
         this.todoService.addTodo(todo);
    }

    @PutMapping("/todos/{todoId}")
    public void updateTodo(@RequestBody Todo todo) {
        this.todoService.updateTodo(todo);
    }

    @DeleteMapping("/todos/{todoId}")
    public void deleteTodo(@PathVariable Integer todoId) {
        this.todoService.deleteTodo(todoId);
    }
}
