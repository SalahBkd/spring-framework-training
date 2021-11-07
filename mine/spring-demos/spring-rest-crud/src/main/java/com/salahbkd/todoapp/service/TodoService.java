package com.salahbkd.todoapp.service;

import com.salahbkd.todoapp.dao.TodoRepository;
import com.salahbkd.todoapp.entity.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> getTodos() {
        List<Todo> todos = new ArrayList<>();
        todoRepository.findAll().forEach(todos::add);
        return todos;
    }

    public Optional<Todo> getTodo(Integer todoId) {
        return todoRepository.findById(todoId);
    }

    public void addTodo(Todo todo) {
       todoRepository.save(todo);
    }

    public void updateTodo(Todo todo) {
      todoRepository.save(todo);
    }

    public void deleteTodo(Integer todoId) {
        todoRepository.deleteById(todoId);
    }
}
